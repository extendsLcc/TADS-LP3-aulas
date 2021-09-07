/*
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS
	tb_produto,
    tb_tipo_funcionario,
    tb_estado,
    tb_cidade,
    tb_bairro,
    tb_endereco,
    tb_pessoa,
    tb_funcionario,
    tb_nota,
    tb_itens_nota,
    tb_atendentes_nota;
SET foreign_key_checks = 1;
*/


CREATE DATABASE loja_joaquim;
USE
loja_joaquim;


-- CREATE TABLE IF NOT EXISTS tb_produto (
CREATE TABLE tb_produto
(
    id_produto     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome           VARCHAR(45)    NOT NULL,
    valor_unitario DECIMAL(12, 2) NOT NULL,

    PRIMARY KEY (id_produto),
    UNIQUE INDEX id_prod_UNIQUE (id_produto ASC)
);

CREATE TABLE tb_tipo_funcionario
(
    id_tipofunc INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cargo       VARCHAR(45) NOT NULL,

    PRIMARY KEY (id_tipofunc),
    UNIQUE INDEX id_tipofunc_UNIQUE (id_tipofunc ASC)
);

CREATE TABLE tb_estado
(
    id_estado   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome_estado VARCHAR(45) NOT NULL,

    PRIMARY KEY (id_estado),
    UNIQUE INDEX id_estado_UNIQUE (id_estado ASC)
);

CREATE TABLE tb_cidade
(
    id_cidade INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(45) NOT NULL,
    id_estado INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_cidade),
    UNIQUE INDEX id_cidade_UNIQUE (id_cidade ASC),

    INDEX     fk_cidade_estado_idx (id_estado ASC),
    CONSTRAINT fk_cidade_estado
        FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_bairro
(
    id_bairro INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(45) NOT NULL,
    id_cidade INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_bairro),
    UNIQUE INDEX id_bairro_UNIQUE (id_bairro ASC),

    INDEX     fk_bairro_cidade_idx (id_cidade ASC),
    CONSTRAINT fk_bairro_cidade
        FOREIGN KEY (id_cidade) REFERENCES tb_cidade (id_cidade)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_endereco
(
    id_endereco INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome_rua    VARCHAR(45) NOT NULL,
    numero      INT UNSIGNED,
    complemento VARCHAR(45),
    id_bairro   INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_endereco),
    UNIQUE INDEX id_endereco_UNIQUE (id_endereco ASC),

    INDEX       fk_endereco_bairro_idx (id_bairro ASC),
    CONSTRAINT fk_endereco_bairro
        FOREIGN KEY (id_bairro) REFERENCES tb_bairro (id_bairro)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_pessoa
(
    id_pessoa   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(45) NOT NULL,
    cpf         VARCHAR(45) NULL,
    id_endereco INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_pessoa),
    UNIQUE INDEX id_pessoa_UNIQUE (id_pessoa ASC),

    INDEX       fk_pessoa_endereco_idx (id_endereco ASC),
    CONSTRAINT fk_pessoa_endereco
        FOREIGN KEY (id_endereco) REFERENCES tb_endereco (id_endereco)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_funcionario
(
    id_funcionario INT UNSIGNED NOT NULL AUTO_INCREMENT,
    valor_salario  DECIMAL(12, 2) NOT NULL,
    id_pessoa      INT UNSIGNED NOT NULL,
    id_tipofunc    INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_funcionario),
    UNIQUE INDEX id_funcionario_UNIQUE (id_funcionario ASC),

    INDEX          fk_funcionario_pessoa_idx (id_pessoa ASC),
    CONSTRAINT fk_funcionario_pessoa
        FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id_pessoa)
            ON DELETE NO ACTION ON UPDATE NO ACTION,

    INDEX          fk_funcionario_tipofunc_idx (id_tipofunc ASC),
    CONSTRAINT fk_funcionario_tipofunc
        FOREIGN KEY (id_tipofunc) REFERENCES tb_tipo_funcionario (id_tipofunc)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_nota
(
    id_nota        INT UNSIGNED NOT NULL,
    data_venda     DATE           NOT NULL,
    hora_venda     TIME           NOT NULL,
    data_pagamento DATE           NOT NULL,
    valor_nota     DECIMAL(12, 2) NOT NULL,
    id_cliente     INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_nota),
    UNIQUE INDEX id_nota_UNIQUE (id_nota ASC),

    INDEX          fk_nota_cliente_idx (id_cliente ASC),
    CONSTRAINT fk_nota_cliente
        FOREIGN KEY (id_cliente) REFERENCES tb_pessoa (id_pessoa)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_itens_nota
(
    id_itens_nota  INT UNSIGNED NOT NULL AUTO_INCREMENT,
    valor_unitario DECIMAL(12, 2) NOT NULL,
    quantidade     INT UNSIGNED DEFAULT 1,
    id_produto     INT UNSIGNED NOT NULL,
    id_nota        INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_itens_nota),
    UNIQUE INDEX id_itens_nota_UNIQUE (id_itens_nota ASC),

    INDEX          fk_itensnota_produto_idx (id_produto ASC),
    CONSTRAINT fk_itensnota_produto
        FOREIGN KEY (id_produto) REFERENCES tb_produto (id_produto)
            ON DELETE NO ACTION ON UPDATE NO ACTION,

    INDEX          fk_itensnota_nota_idx (id_nota ASC),
    CONSTRAINT fk_itensnota_nota
        FOREIGN KEY (id_nota) REFERENCES tb_nota (id_nota)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE tb_atendentes_nota
(
    id_atendentes_nota INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_nota            INT UNSIGNED NOT NULL,
    id_vendedor        INT UNSIGNED NOT NULL,
    id_caixa           INT UNSIGNED NOT NULL,

    PRIMARY KEY (id_atendentes_nota),
    UNIQUE INDEX id_atendentes_nota_UNIQUE (id_atendentes_nota ASC),

    INDEX              fk_atendentesnota_nota_idx (id_nota ASC),
    CONSTRAINT fk_atendentesnota_nota
        FOREIGN KEY (id_nota) REFERENCES tb_nota (id_nota)
            ON DELETE NO ACTION ON UPDATE NO ACTION,

    INDEX              fk_atendentesnota_vend_idx (id_vendedor ASC),
    CONSTRAINT fk_atendentesnota_vend
        FOREIGN KEY (id_vendedor) REFERENCES tb_funcionario (id_funcionario)
            ON DELETE NO ACTION ON UPDATE NO ACTION,

    INDEX              fk_atendentesnota_caixa_idx (id_caixa ASC),
    CONSTRAINT fk_atendentesnota_caixa
        FOREIGN KEY (id_caixa) REFERENCES tb_funcionario (id_funcionario)
            ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- ------------------------------------------------------------------------
-- ------------------------------------------------------------------------

INSERT INTO tb_produto
VALUES (1, 'Cinto', 11.20),
       (2, 'Sapato', 92.00),
       (3, 'Meia', 7.00),
       (4, 'Tenis', 321.20),
       (5, 'Sandália', 35.00);

INSERT INTO tb_tipo_funcionario
VALUES (1, 'Vendedor'),
       (2, 'Caixa'),
       (3, 'Gerente'),
       (4, 'Contador');

INSERT INTO tb_estado
VALUES (1, 'Paraná'),
       (2, 'São Paulo'),
       (3, 'Santa Catarina'),
       (4, 'Rio Grande do Sul'),
       (5, 'Rio de Janeiro');

INSERT INTO tb_cidade
VALUES (1, 'Umuarama', 1),
       (2, 'Maringá', 1),
       (3, 'Curitiba', 1),
       (4, 'Florianópolis', 3),
       (5, 'Porto Alegre', 4),
       (6, 'Arraial do Cabo', 5),
       (7, 'Angatuba', 2);

INSERT INTO tb_bairro
VALUES (1, 'Zona III', 1),
       (2, 'Zona II', 1),
       (3, 'Zona I', 1),
       (4, 'Zona VI', 1),
       (5, 'Zona V', 1),
       (6, 'Zona VII', 2),
       (7, 'Centro', 3),
       (8, 'Jardim das Américas', 3),
       (9, 'Mandacarú', 2),
       (10, 'Portão', 3),
       (11, 'Estreito', 4),
       (12, 'Centro Histórico', 4),
       (13, 'Trindade', 4),
       (14, 'Jardim Tropical', 1),
       (15, 'Jardim Carolina', 1),
       (16, 'Parque Lago', 1);

INSERT INTO tb_endereco
VALUES (1, 'Av. Paraná', 5885, 'Supermercado Cancão', 1),                              -- zona 3
       (2, 'Av. São Paulo', 4981, 'Colégio Malba Tahan', 2),                           -- zona 2
       (3, 'Av. Pres. Castelo Branco', 4416, 'Parque Xetás', 4),                       -- zona VI
       (4, 'Av. Gov. Parigot de Souza', 2710, 'Cemitério', 3),                         -- zona I
       (5, 'Av. Pres. Castelo Branco', 3745, 'Hotel Caiuá', 3),                        -- zona I
       (6, 'Av. Colombo', 5790, 'UEM', 6),                                             -- Zona 7, Maringá
       (7, 'Av. Cel. Francisco H. dos Santos', 100, 'universidade federal paraná', 8), -- Jardim das Américas, Curitiba
       (8, 'R. XV de Novembro', 1299, 'praça central curitiba', 7),                    -- Centro, Curitiba
       (9, 'Av. Prof. Henrique da Silva Fontes', 970, 'Corpo bombeiros militar', 13),  -- Trindade, Florianópolis
       (10, 'Praça XV de Novembro', 0, 'centro historico', 12),                        -- Centro, Florianópolis
       (11, 'Av. Rio Grande do Norte', 3295, 'casa', 14),                              -- Jardim Tropical, Umuarama
       (12, 'R. Amazonas', 3346, 'casa', 2),                                           -- Zona II, Umuarama
       (13, 'R. Marialva', 4829, 'térreo', 1),                                         -- Zona III, Umuarama
       (14, 'R. Generino Delfino Coelho', 3341, 'apto 22', 15),                        -- Jardim Carolina, Umuarama
       (15, 'R. Cisne', 2804, 'apto 44', 16),                                          -- Parque Lago, Umuarama
       (16, 'R. Porto Alegre', 4889, 'sobreloja', 5); -- Zona V, Umuarama

INSERT INTO tb_pessoa
VALUES (1, 'Ana Beatriz', '012.987.654-11', 11),
       (2, 'Roberto Carlos', '099.888.777-22', 12),
       (3, 'Carlos Alberto', '022.333.444-55', 14),
       (4, 'Darlon Rodrigues', '033.888.555-02', 14),
       (5, 'Amélia das Dores', '061.444.888-25', 15),
       (6, 'Lúcia Serafim', '045.987.354-77', 16),
-- ###########################
       (7, 'Albert Einstein', '000.111.222-33', 1),
       (8, 'Gautama Buddha', '111.333.555-77', 2),
       (9, 'Mahatma Gandhi', '222.444.666-88', 3),
       (10, 'Madre Tereza Calcutá', '999.777.555-33', 4),
       (11, 'Frida Kahlo', '888.666.444-22', 5),
       (12, 'Martin Luther King', '555.222.888-33', 6),
       (13, 'Karl Marx', '777.444.111-88', 7),
       (14, 'Chico Xavier', '999.666.333-55', 8),
       (15, 'Sigmund Freud', '951.357.852-46', 9),
       (16, 'Nelson Mandela', '013.465.798-82', 10);

INSERT INTO tb_funcionario
VALUES (1, 2000, 1, 1),
       (2, 2100, 2, 1),
       (3, 2000, 3, 1),
       (4, 2000, 4, 1),
       (5, 2500, 5, 2),
       (6, 2500, 6, 2);

INSERT INTO tb_nota
VALUES (1, '2021-03-03', '12:15', '2021-04-03', 110.20, 7),
       (2, '2021-03-03', '13:15', '2021-03-15', 321.20, 8),
       (3, '2021-03-03', '14:15', '2021-03-20', 70.00, 9),
       (4, '2021-03-03', '15:15', '2021-04-03', 342.20, 10),
       (5, '2021-03-05', '08:15', '2021-04-05', 103.20, 11),
       (6, '2021-03-05', '09:15', '2021-04-05', 335.20, 12),
       (7, '2021-03-05', '10:15', '2021-04-05', 92.00, 13),
       (8, '2021-03-05', '11:15', '2021-04-05', 138.20, 14),
       (9, '2021-03-07', '13:50', '2021-04-07', 127.00, 15),
       (10, '2021-03-07', '15:20', '2021-04-07', 25.00, 16);

INSERT INTO tb_itens_nota
VALUES (1, 11.20, 1, 1, 1),
       (2, 92.00, 1, 2, 1),
       (3, 7.00, 1, 3, 1),
--
       (4, 321.20, 1, 4, 2),
--
       (5, 35.00, 2, 5, 3),
--
       (6, 321.20, 1, 4, 4),
       (7, 7.00, 3, 3, 4),
--
       (8, 11.20, 1, 1, 5),
       (9, 92.00, 1, 2, 5),
--
       (10, 321.20, 1, 4, 6),
       (11, 7.00, 2, 3, 6),
--
       (12, 92.00, 1, 2, 7),
--
       (13, 11.20, 1, 1, 8),
       (14, 92.00, 1, 2, 8),
       (15, 35.00, 1, 5, 8),
--
       (16, 92.00, 1, 2, 9),
       (17, 35.00, 1, 5, 9),
--
       (18, 10.00, 1, 1, 10),
       (19, 5.00, 3, 3, 10);

INSERT INTO tb_atendentes_nota
VALUES (1, 1, 1, 5),
       (2, 2, 2, 6),
       (3, 3, 3, 5),
       (4, 4, 4, 6),
       (5, 5, 1, 6),
       (6, 6, 1, 6),
       (7, 7, 2, 6),
       (8, 8, 3, 6),
       (9, 9, 1, 5),
       (10, 10, 4, 5);