package br.com.fujideia.iesp.tecback.validators;

import java.util.Arrays;
import java.util.List;

public class DiretorBase {

    private static final List<String> DIRETORES = Arrays.asList(
            "Steven Spielberg", "Christopher Nolan", "Martin Scorsese", "Quentin Tarantino", "James Cameron",
            "Ridley Scott", "Alfred Hitchcock", "Stanley Kubrick", "Francis Ford Coppola", "Peter Jackson",
            "Tim Burton", "David Fincher", "Guillermo del Toro", "Clint Eastwood", "George Lucas",
            "Akira Kurosawa", "Sofia Coppola", "Wes Anderson", "Paul Thomas Anderson", "Spike Lee",
            "Hayao Miyazaki", "Damien Chazelle", "Patty Jenkins", "Ang Lee", "Taika Waititi",
            "Greta Gerwig", "Bong Joon-ho", "Jordan Peele", "Ava DuVernay", "Sam Mendes",
            "Robert Zemeckis", "Ron Howard", "J.J. Abrams", "Guy Ritchie", "Denis Villeneuve",
            "Lana Wachowski", "Lilly Wachowski", "John Carpenter", "Kathryn Bigelow", "Michael Bay",
            "Mel Gibson", "Terrence Malick", "Woody Allen", "Jean-Luc Godard", "Ingmar Bergman",
            "Luc Besson", "Alejandro González Iñárritu", "Pedro Almodóvar", "Rob Reiner", "Brian De Palma",
            "Billy Wilder", "Orson Welles", "Frank Capra", "John Ford", "Sergio Leone",
            "William Wyler", "George Cukor", "Howard Hawks", "Robert Altman", "David Lynch",
            "Ken Loach", "John Huston", "Yasujirō Ozu", "Federico Fellini", "Michelangelo Antonioni",
            "Luchino Visconti", "Pier Paolo Pasolini", "Roman Polanski", "Franco Zeffirelli", "Rainer Werner Fassbinder",
            "Wim Wenders", "Werner Herzog", "Fritz Lang", "Luis Buñuel", "Carlos Saura",
            "José Padilha", "Fernando Meirelles", "Walter Salles", "Cacá Diegues", "Hector Babenco",
            "Leon Hirszman", "Nelson Pereira dos Santos", "Ruy Guerra", "Anna Muylaert", "Kleber Mendonça Filho",
            "Beto Brant", "Fernando Coimbra", "Glauber Rocha", "Karim Aïnouz", "Daniel Filho",
            "Andrucha Waddington", "José Mojica Marins", "Eduardo Coutinho", "Aluizio Abranches", "Afonso Poyart"
    );

    public static boolean isDiretorValido(String nomeDiretor) {
        return DIRETORES.stream().anyMatch(diretor -> diretor.equalsIgnoreCase(nomeDiretor));
    }
}
