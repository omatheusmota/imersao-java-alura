import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        //1. leitura da imagem

        //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg")); // para ler arquivos locais
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //2. criar nova imagem com transparência e novo tamanho

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //3. copiar a imagem original pra nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //4. formatar a fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(fonte);


        //5. escrever uma frase na nova imagem 

        graphics.drawString("CHUVA CHIC", 133, novaAltura - 88);

        //6. escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}
