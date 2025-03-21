
package produtos;

import java.io.IOException;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(String codigo, String nome, String descricao, String deposito, 
    		MultipartFile imagem, Double custo, Double valor) throws Exception {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Produto deve conter um código valido.");
        }
        
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Produto deve conter um nome valido.");
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Produto deve conter uma descrição valido.");
        }
        
        if (deposito == null || deposito.trim().isEmpty()) {
            throw new IllegalArgumentException("Produto deve conter um deposito valido.");
        }
        
        if (custo == null || custo == 0) {
            throw new IllegalArgumentException("Produto deve conter um custo valido.");
        }
        
        if (valor == null || valor == 0) {
            throw new IllegalArgumentException("Produto deve conter um valor valido.");
        }

        Blob imageBlob;
		try {
		    imageBlob = new SerialBlob(imagem.getBytes());
		}catch (Exception e) {
		    throw new IOException("Erro ao converter imagem para Blob ", e);
		}

        Produto novoProduto = new Produto(
        		codigo,
        		nome,
                descricao,
                deposito,
                imageBlob,
                custo,
                valor
        );

        return produtoRepository.save(novoProduto);
    }
}
 