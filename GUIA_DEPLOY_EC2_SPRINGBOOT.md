# Guia rapido: subir o projeto na EC2 (AWS) via Git, sem SSH local

Este roteiro mostra como acessar a instancia **pelo console da AWS**, baixar o projeto do Git na EC2, compilar e fazer o start da aplicacao Spring Boot.

## 1) Pre-requisitos

- Conta AWS ativa.
- Instancia EC2 Linux (Amazon Linux 2023 ou Ubuntu) em `running`.
- Security Group com porta `8080` liberada para teste (`0.0.0.0/0` em aula).
- Repositorio no GitHub/GitLab com o projeto.
- Para acesso sem SSH local, prefira **AWS Systems Manager Session Manager**.

---

## 2) Acessar a EC2 pelo console AWS (sem SSH)

### Opcao principal: Session Manager

No console da AWS:

1. Abra `EC2`.
2. Clique em `Instances`.
3. Selecione sua instancia.
4. Clique em `Connect`.
5. Aba `Session Manager`.
6. Clique em `Connect` para abrir o terminal no navegador.

> Se a opcao Session Manager nao aparecer, veja a secao de problemas no final.

### Opcao alternativa: EC2 Instance Connect (browser)

No mesmo `Connect`, voce pode usar `EC2 Instance Connect` para abrir terminal no navegador.

---

## 3) Preparar ambiente na EC2 (Git + Java 21)

No terminal aberto pelo console AWS, rode:

### Amazon Linux 2023

```bash
sudo dnf update -y
sudo dnf install -y git java-21-amazon-corretto-devel
git --version
java -version
```

### Ubuntu

```bash
sudo apt update
sudo apt install -y git openjdk-21-jdk
git --version
java -version
```

---

## 4) Clonar o projeto na EC2

```bash
git clone URL_DO_SEU_REPOSITORIO
cd tecback
```

Exemplo:

```bash
git clone https://github.com/SEU_USUARIO/tecback.git
cd tecback
```

> Se o repositorio for privado, voce vai precisar autenticar (token pessoal ou chave SSH).

---

## 5) Compilar o projeto na EC2

```bash
chmod +x mvnw
./mvnw clean package -DskipTests
```

Depois confirme o JAR:

```bash
ls -lh target/*.jar
```

---

## 6) Fazer start da aplicacao na EC2

```bash
nohup java -jar target/techback-1.0.0-17032026.jar --spring.profiles.active=dev > app.log 2>&1 &
```

Se o nome do JAR for diferente, ajuste no comando.

Verificar se subiu:

```bash
ps -ef | grep techback
tail -n 100 app.log
```

---

## 7) Testar acesso publico

No navegador (ou Postman):

```text
http://SEU_IP_PUBLICO:8080/filmes
```

Swagger (se ativo no projeto):

```text
http://SEU_IP_PUBLICO:8080/swagger-ui/index.html
```

---

## 8) Atualizar o projeto depois (novo deploy)

Quando subir codigo novo no Git:

```bash
cd ~/tecback
pkill -f techback
git pull
./mvnw clean package -DskipTests
nohup java -jar target/techback-1.0.0-17032026.jar --spring.profiles.active=dev > app.log 2>&1 &
```

---

## 9) Comandos uteis

Parar app:

```bash
pkill -f techback
```

Ver log em tempo real:

```bash
tail -f app.log
```

Checar porta 8080:

```bash
sudo ss -lntp | grep 8080
```

---

## 10) Checklist rapido de problemas

1. **Session Manager nao conecta**
   - A instancia precisa ter IAM Role com permissoes do SSM.
   - O SSM Agent deve estar instalado/ativo.
   - A instancia precisa saida para internet/NAT/VPC endpoints do SSM.
2. **Erro ao clonar repositorio**
   - URL incorreta.
   - Repositorio privado sem autenticacao.
3. **Aplicacao nao abre em `:8080`**
   - Porta `8080` fechada no Security Group.
   - Processo Java nao iniciou.
4. **Erro de Java/Maven**
   - Java 21 nao instalado (`java -version`).
   - Build falhou (`./mvnw clean package`).

---

## 11) Proximo nivel (opcional)

- Criar servico `systemd` para subir no boot.
- Colocar Nginx na frente (80/443).
- Usar banco externo (RDS).
- Configurar dominio + HTTPS.
