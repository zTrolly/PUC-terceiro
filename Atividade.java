class Atividade{

    abstract class Pessoa{
        /**
         * @param nome
         * @param endereco
         * @param telefone
         * @param cep
         * @param cidade
         * @param uf
         */
        private String nome;
        private String endereco;
        private String telefone;
        private String cep;
        private String cidade;
        private String uf;

        //getters
        public String getNome(){return this.nome;}
        public String getEndereco(){return this.endereco;}
        public String getTelefone(){return this.telefone;}
        public String getCep(){return this.cep;}
        public String getCidade(){return this.cidade;}
        public String getUf(){return this.uf;}

        //sets
        public void setNome(String nome){this.nome = nome;}
        public void setEndereco(String endereco){this.endereco = endereco;}
        public void setTelefone(String telefone){this.telefone = telefone;}
        public void setCep(String cep){this.cep = cep;}
        public void setCidade(String cidade){this.cidade = cidade;}
        public void setUf(String uf){this.uf = uf;}


        public Pessoa(String nome, String endereco, String telefone, String cep, String cidade, String uf) {
            this.setNome(nome);
            this.setEndereco(endereco);
            this.setTelefone(telefone);
            this.setCep(cep);
            this.setCidade(cidade);
            this.setUf(uf);
        }
    }

    class PessoaJuridica extends Pessoa{

        /**
         * @param nome
         * @param endereco
         * @param telefone
         * @param cep
         * @param cidade
         * @param uf
         */
        private long cnpj;

        public PessoaJuridica(String nome, String endereco, String telefone, String cep, String cidade, String uf, long cnpj) {
            super(nome, endereco, telefone, cep, cidade, uf);
            this.cnpj = cnpj;
        }

        //get
        public long getCnpj(){return this.cnpj;}
        
        //set
        public void setCnpj(long cnpj){this.cnpj = cnpj;}


    }

    class PessoaFisica extends Pessoa{

        /**
         * @param nome
         * @param endereco
         * @param telefone
         * @param cep
         * @param cidade
         * @param uf
         */
        private long cpf;
        public PessoaFisica(String nome, String endereco, String telefone, String cep, String cidade, String uf, long cpf) {
            super(nome, endereco, telefone, cep, cidade, uf);
            this.cpf = cpf;
        }
        
        //get
        public long getCpf(){return this.cpf;}
        
        //set
        public void setCpf(long cpf){this.cpf = cpf;}


    }

    class Cliente{

    }

    class Funcionario{}
    
    class Empresa{}
}