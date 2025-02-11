package br.uniesp.si.techback;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bemvindos")
public class AulaController {

    @GetMapping
    public String getMethod(){
        return "Bem vindos";
    }
}
