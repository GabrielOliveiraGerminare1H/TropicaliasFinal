package Model;

public class CorMascote {
    // Atributos da classe CorMascote
    private String textoFundo;  // Texto da cor de fundo
    private String textoPri;     // Texto da cor principal
    private String textoSec;     // Texto da cor secundário

    // Construtor da classe
    public CorMascote(String textoFundo, String textoPri, String textoSec) {
        this.textoFundo = textoFundo;
        this.textoPri = textoPri;
        this.textoSec = textoSec;
    }

    // Métodos getters e setters para acessar e codificar os atributos


    public String getTextoFundo() {
        return textoFundo;
    }

    public void setTextoFundo(String textoFundo) {
        this.textoFundo = textoFundo;
    }

    public String getTextoPri() {
        return textoPri;
    }

    public void setTextoPri(String textoPri) {
        this.textoPri = textoPri;
    }

    public String getTextoSec() {
        return textoSec;
    }

    public void setTextoSec(String textoSec) {
        this.textoSec = textoSec;
    }

    // Método toString para representar o objeto CorMascote
    @Override
    public String toString() {
        return "--Texto do fundo: " + this.textoFundo +
                "\n--Texto primário: " + this.textoPri +
                "\n--Texto secundário: " + this.textoSec;
    }
}
