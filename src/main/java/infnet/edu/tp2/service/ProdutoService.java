package infnet.edu.tp2.service;

import infnet.edu.tp2.exception.ResourceNotFoundException;
import infnet.edu.tp2.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    List<Produto> produtos = initValues();

    private List<Produto> initValues() {
        ArrayList<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto(0, "Caneta", 8.5, 1));
        produtos1.add(new Produto(1, "Revista", 15.43, 7));
        return produtos1;
    }

    public List<Produto> getAll() {
        return this.produtos;
    }

    public Produto getById(int id) {
        if(id < 0){
            throw new ResourceNotFoundException("Valor inválido - Não pode ser negativo");
        } else {
            Optional<Produto> produtoOpt = produtos.stream().filter(produto -> produto.getCodigo() == id).findFirst();
            if(produtoOpt.isEmpty()) throw  new ResourceNotFoundException("Objeto não encontrado");
            return produtoOpt.get();
        }
    }

    public void save(Produto usuario) {
        produtos.add(usuario);
    }

    public void update(Integer id, Produto produto) {
        if(resourceNotFound(id)) {
            throw new ResourceNotFoundException("Produto Não Localizada");
        }
        produtos.set(id, produto);
    }

    public void deleteById(Integer id) {
        if(resourceNotFound(id)) {
            throw new ResourceNotFoundException("Produto Não Localizada");
        }
        produtos.remove(produtos.get(id));
    }

    private boolean resourceNotFound(Integer id) {
        return produtos.stream().filter(produtos -> produtos.getCodigo() == id).findFirst().isEmpty();
    }

}