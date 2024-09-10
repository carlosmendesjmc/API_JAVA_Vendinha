CREATE TABLE USERS (
                       ID INTEGER PRIMARY KEY AUTO_INCREMENT,  -- Coluna ID é a chave primária, do tipo INTEGER, e será auto-incrementada automaticamente pelo banco de dados.
                       NAME VARCHAR(255),                      -- Coluna NAME armazena o nome do usuário, com um máximo de 255 caracteres.
                       EMAIL VARCHAR(255),
                       PASSWORD VARCHAR(255),
                       CPF VARCHAR(255),
                       CNPJ VARCHAR(255)
);

CREATE TABLE PRODUTO (
                         ID INT PRIMARY KEY AUTO_INCREMENT,      -- Coluna ID é a chave primária, do tipo INTEGER, e será auto-incrementada automaticamente pelo banco de dados.
                         NAME VARCHAR(255),                      -- Coluna NAME armazena o nome do usuário, com um máximo de 255 caracteres.
                         QUANTIDADE INT,
                         PRECO DECIMAL(10,2)                     -- Usando DECIMAL para precisão em valores monetários.
);
