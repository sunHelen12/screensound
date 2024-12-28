
## Descrição do Projeto

O **Screensound** é uma aplicação Java para gerenciamento de artistas e músicas. Com ela, você pode cadastrar artistas, associar músicas aos artistas cadastrados, listar músicas disponíveis e buscar informações sobre artistas. Além disso, a aplicação integra uma funcionalidade experimental para pesquisar dados sobre um artista usando uma API de inteligência artificial.

Este projeto foi desenvolvido como parte do programa **One Oracle Next Generation**, em parceria com a **Alura**, com o objetivo de promover o aprendizado de desenvolvimento de software e boas práticas em programação.

---

## Funcionalidades

1. **Cadastrar Artistas**  
   Permite o cadastro de artistas no banco de dados com o nome e o tipo (Solo, Dupla, ou Banda).

2. **Cadastrar Músicas**  
   Associar músicas aos artistas já cadastrados.

3. **Listar Músicas**  
   Lista todas as músicas cadastradas no sistema, organizadas por artista.

4. **Buscar Músicas por Artista**  
   Busca e lista todas as músicas de um artista específico.

5. **Pesquisar Dados do Artista**  
   (Experimental) Utiliza a API OpenAI para obter informações sobre o artista inserido.

6. **Sair**  
   Encerra a aplicação.

---

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal da aplicação.
- **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
- **Maven**: Gerenciamento de dependências e build.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados de artistas e músicas.
- **OpenAI API**: Integração para buscar informações sobre artistas. *(Ver limitações abaixo)*

---

## Requisitos

### Softwares
- **Java 17+** instalado no ambiente.
- **PostgreSQL** instalado e configurado.

### Dependências Gerenciadas pelo Maven
- Spring Boot Starter Data JPA
- Driver PostgreSQL
- Jackson (para manipulação de JSON)
- OpenAI Java API (via JitPack)

---

## Banco de Dados

### Configuração
O banco de dados utilizado pela aplicação é o **PostgreSQL**. O esquema da aplicação contém duas tabelas principais:
1. **Artistas**
   - Campos:
     - `id`: Chave primária do artista.
     - `nome`: Nome do artista.
     - `tipo`: Tipo do artista (Solo, Dupla ou Banda).
2. **Músicas**
   - Campos:
     - `id`: Chave primária da música.
     - `nome`: Nome da música.
     - `artista_id`: Chave estrangeira que associa a música a um artista.

### Configuração no `application.properties`
Certifique-se de configurar corretamente o arquivo `application.properties` no diretório `src/main/resources` com as credenciais do banco, como exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

---

## Limitações e Observações Importantes

1. **API OpenAI Não Funciona Adequadamente**
   - A integração com a API da OpenAI está configurada para usar a biblioteca `openai-java`, mas erros como "Missing artifact" ou problemas de versão podem ocorrer devido a incompatibilidades no Maven ou instabilidade da dependência no repositório JitPack.
   - Caso a funcionalidade de busca de dados do artista não funcione, verifique se a chave de API da OpenAI foi configurada corretamente na variável de ambiente `OPENAI_APIKEY`. Ainda assim, pode haver necessidade de ajustes na configuração do Maven.

2. **Controle de Entrada**
   - A aplicação depende de entradas válidas do usuário para funcionar corretamente. Entradas inválidas ou ausência de dados podem gerar erros ou resultados inesperados.

3. **Funcionalidade Experimental**
   - A funcionalidade de busca de informações sobre artistas é experimental e não garante resultados consistentes devido à dependência externa da API.

---

## Como Executar

1. **Clone o Repositório**
   ```bash
   git clone <url-do-repositorio>
   cd screensound
   ```

2. **Configure o Banco de Dados**
   - Certifique-se de que o PostgreSQL está rodando e as configurações no arquivo `application.properties` estão corretas.

3. **Compile e Execute a Aplicação**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Use a Aplicação no Terminal**
   - O menu será exibido no terminal. Escolha as opções desejadas e siga as instruções.

---

## Melhorias Futuras

1. **Adicionar Álbuns**
   - Expandir a aplicação para incluir o gerenciamento de álbuns musicais, permitindo associar músicas a álbuns e organizá-las de forma hierárquica.

2. **Adicionar Validações nas Entradas**
   - Implementar validações para garantir que as informações inseridas pelos usuários sejam consistentes e evitar erros durante a execução.

3. **Melhorar a Integração com a API OpenAI**
   - Resolver problemas de dependência e garantir maior estabilidade para a funcionalidade de busca de dados do artista.

4. **Criar uma Interface Gráfica ou API REST**
   - Facilitar o uso da aplicação por meio de uma interface mais amigável ou permitir sua integração com outros sistemas via API REST.

5. **Implementar Testes**
   - Adicionar testes unitários e de integração para garantir a qualidade do código e evitar regressões.

---

Com isso, você pode utilizar o **Screen Sound Músicas** para gerenciar artistas e músicas de forma simples e eficiente! 🚀
