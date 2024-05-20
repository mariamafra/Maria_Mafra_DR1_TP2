package infnet.edu.tp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;
}
