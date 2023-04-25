insert into tb_categoria (id, nome) values (1, 'Informatica');
insert into tb_categoria (id, nome) values (2, 'Escritorio');

insert into tb_produto (id, nome, preco) values (1, 'Computador', 2000);
insert into tb_produto (id, nome, preco) values (2, 'Impressora', 800);
insert into tb_produto (id, nome, preco) values (3, 'Mouse', 80);

insert into tb_produto_categorias (produtos_id, categorias_id) values (1, 1), (2, 1), (3, 1), (2, 2);
