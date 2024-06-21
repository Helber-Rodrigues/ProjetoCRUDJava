public class Cliente extends ClienteDAO {
    private int id;    
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String cidade;
    private String uf;
  
  Cliente(){
    nome="";
    idade=0;
    cpf="";
    telefone="";
    cidade="";
    uf="";
  }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public void cadastrar(){
       insertMySQL(nome,idade,cpf,telefone,cidade,uf);
    }  
}

    
  
  