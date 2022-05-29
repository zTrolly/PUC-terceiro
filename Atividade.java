class Atividade {

    abstract class Pessoa {
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

        // getters
        public String getNome() {
            return this.nome;
        }

        public String getEndereco() {
            return this.endereco;
        }

        public String getTelefone() {
            return this.telefone;
        }

        public String getCep() {
            return this.cep;
        }

        public String getCidade() {
            return this.cidade;
        }

        public String getUf() {
            return this.uf;
        }

        // sets
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public Pessoa(String nome, String endereco, String telefone, String cep, String cidade, String uf) {
            this.setNome(nome);
            this.setEndereco(endereco);
            this.setTelefone(telefone);
            this.setCep(cep);
            this.setCidade(cidade);
            this.setUf(uf);
        }
    }

    class PessoaJuridica extends Pessoa {

        /**
         * @param nome
         * @param endereco
         * @param telefone
         * @param cep
         * @param cidade
         * @param uf
         * @param cnpj
         */
        private long cnpj;

        public PessoaJuridica(String nome, String endereco, String telefone, String cep, String cidade, String uf,
                long cnpj) {
            super(nome, endereco, telefone, cep, cidade, uf);
            this.setCnpj(cnpj);
        }

        // get
        public long getCnpj() {
            return this.cnpj;
        }

        // set
        public void setCnpj(long cnpj) {
            this.cnpj = cnpj;
        }

    }

    class PessoaFisica extends Pessoa {

        /**
         * @param nome
         * @param endereco
         * @param telefone
         * @param cep
         * @param cidade
         * @param uf
         * @param cpf
         */
        private long cpf;

        public PessoaFisica(String nome, String endereco, String telefone, String cep, String cidade, String uf,
                long cpf) {
            super(nome, endereco, telefone, cep, cidade, uf);
            this.setCpf(cpf);
        }

        // get
        public long getCpf() {
            return this.cpf;
        }

        // set
        public void setCpf(long cpf) {
            this.cpf = cpf;
        }

    }

    class Cliente {
        private Pessoa pessoa;
        private float limiteDeCredito;

        /**
         * 
         * @return the pessoa
         */
        public Pessoa getPessoa() {
            return pessoa;
        }
        /**
         * @param pessoa the pessoa to set
         */
        public void setPessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
        }
        /**
         * @return the limiteDeCredito
         */
        public float getLimiteDeCredito() {
            return limiteDeCredito;
        }
        /**
         * @param limiteDeCredito the limiteDeCredito to set
         */
        public void setLimiteDeCredito(float limiteDeCredito) {
            this.limiteDeCredito = limiteDeCredito;
        }

        public Cliente(Pessoa pessoa, float limiteDeCredito){
            this.setLimiteDeCredito(limiteDeCredito);
            this.setPessoa(pessoa);
        }

    }

    class Funcionario {
        private PessoaFisica funcionario;
        private String cargo;
        private float salario;

        /**
         * @return the funcionario
         */
        public PessoaFisica getFuncionario() {
            return funcionario;
        }

        /**
         * @param funcionario the funcionario to set
         */
        public void setFuncionario(PessoaFisica funcionario) {
            this.funcionario = funcionario;
        }
        
        /**
         * @return the cargo
         */
        public String getCargo() {
            return cargo;
        }

        /**
         * @param cargo the cargo to set
         */
        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        /**
         * @return the salario
         */
        public float getSalario() {
            return salario;
        }

        /**
         * @param salario the salario to set
         */
        public void setSalario(float salario) {
            this.salario = salario;
        }


        public Funcionario(PessoaFisica funcionario, String cargo, float salario){
            this.setFuncionario(funcionario);
            this.setCargo(cargo);
            this.setSalario(salario);
        }

    }
    
    class Empresa {
        private Cliente[] listaClientes;
        private Funcionario[] listaFuncionarios;
        private Funcionario presidente;

        /**
         * @return the listaClientes
         */
        public Cliente[] getListaClientes() {
            return listaClientes;
        }

        /**
         * @param listaClientes the listaClientes to set
         */
        public void setListaClientes(Cliente[] listaClientes) {
            this.listaClientes = listaClientes;
        }

        /**
         * @return the listaFuncionarios
         */
        public Funcionario[] getListaFuncionarios() {
            return listaFuncionarios;
        }

        /**
         * @param listaFuncionarios the listaFuncionarios to set
         */
        public void setListaFuncionarios(Funcionario[] listaFuncionarios) {
            this.listaFuncionarios = listaFuncionarios;
        }

        /**
         * @return the presidente
         */
        public Funcionario getPresidente() {
            return presidente;
        }

        /**
         * @param presidente the presidente to set
         */
        public void setPresidente(Funcionario presidente) {
            this.presidente = presidente;
        }
        
        public Empresa(Cliente[] listaClientes, Funcionario[] listaFuncionarios, Funcionario presidente ){
            this.setListaClientes(listaClientes);
            this.setListaFuncionarios(listaFuncionarios);
            this.setPresidente(presidente);
        }
        
    }
}

/**
 * Utilize herança e polimorfismo e implemente os seguintes requisitos.
 * 
 * Implemente uma classe pessoa que irá armazenar dados pessoais: nome,
 * endereço, telefone, cep, cidade e uf.
 * Crie subclasses PessoaFisica e PessoaJuridica, que especificam o
 * comportamento de Pessoa.
 * Crie uma classe Empresa que armazena uma lista de Clientes e de Funcionários.
 * Clientes podem ser pessoas físicas ou jurídicas, mas funcionários podem ser
 * apenas pessoas físicas. Clientes possuem um limite de crédito, enquanto
 * funcionários possuem cargo e salário.
 * Suponha agora que a Empresa deseje armazenar em atributo próprio o seu
 * Presidente, sendo que o Presidente da empresa é também um Funcionário.
 * Seu trabalho deve seguir as seguintes diretrizes:
 * 
 * Desenvolva os métodos necessários para que as relações entre as classes sejam
 * funcionais.
 * Utilize todos os princípios da POO: encapsulamento, herança e polimorfismo.
 * Implemente todos os métodos de acesso e construtores com parâmetros.
 * Dicas de alguns princípios que devem ser seguidos:
 * 
 * Information Hiding Principle - proteja os atributos e publique os métodos
 * Low Coupling Principle - módulos externos não devem conhecer aspectos
 * internos de implementação de um módulo.
 * DRY (Don't Repeat Yourself) - sua aplicação não deve possuir repetição de
 * código.
 * OCP - Open/Close Principle - A aplicação deve estar aberta para extensão e
 * fechado para modificação. Isso significa que o código deve ser extensível sem
 * a necessidade de alterar códigos já implementados.
 * DIP - Dependence Inversion Principle - Um módulo deve depender de abstrações.
 * Isso significa que deve-se usar classes abstratas para criar código genérico.
 */