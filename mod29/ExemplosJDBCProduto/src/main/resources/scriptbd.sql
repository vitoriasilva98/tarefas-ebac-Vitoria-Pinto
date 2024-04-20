CREATE DATABASE bd_mod29;

create table tb_cliente (
                            id SERIAL PRIMARY KEY NOT NULL,
                            codigo VARCHAR(10) NOT NULL,
                            nome VARCHAR(50) NOT NULL
);

create sequence sq_cliente
    start 1
    increment 1
    owned by tb_cliente.id;

select * from tb_cliente;
drop table tb_cliente;

-- insert into tb_cliente values('Maria', 20);

create table tb_produto (
                            pro_id serial primary key not null,
                            descricao varchar(50) not null,
                            codigo_de_barra varchar(10) not null unique,
                            preco float not null
);

create sequence sq_produto
    start 1
    increment 1
    owned by tb_produto.pro_id;

drop table tb_produto;

-- insert into tb_produto (descricao, codigo_de_barra, preco) VALUES ('caneta', 'can01', 2.50);

select * from tb_produto;