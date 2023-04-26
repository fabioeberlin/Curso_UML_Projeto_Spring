insert into tb_categoria (id, nome) values (1, 'Informatica');
insert into tb_categoria (id, nome) values (2, 'Escritorio');

insert into tb_produto (id, nome, preco) values (1, 'Computador', 2000);
insert into tb_produto (id, nome, preco) values (2, 'Impressora', 800);
insert into tb_produto (id, nome, preco) values (3, 'Mouse', 80);
insert into tb_produto (id, nome, preco) values (4, 'Teste', 180);

insert into tb_produto_categorias (produtos_id, categorias_id) values (1, 1), (2, 1), (3, 1), (2, 2);

insert into tb_estado (id, nome) values (1, 'Sao Paulo');
insert into tb_estado (id, nome) values (2, 'Minas Gerais');

insert into tb_cidade (id, nome, estado_id) values (1, 'Sorocaba', 1);
insert into tb_cidade (id, nome, estado_id) values (2, 'Campinas', 1);
insert into tb_cidade (id, nome, estado_id) values (3, 'Belo Horizonte', 2);

insert into tb_cliente (id, cpf_ou_cnpj, email, nome, tipo) values (1, '111.111.111.11', 'maria@gmail.com', 'Maria', 0);
insert into tb_cliente (id, cpf_ou_cnpj, email, nome, tipo) values (2, '222.222.222.22', 'joao@gmail.com', 'Joao', 0);
insert into tb_cliente (id, cpf_ou_cnpj, email, nome, tipo) values (3, '11.222.333/0001-11', 'xpto@gmail.com', 'XPTO', 1);

insert into tb_endereco (id, bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) values (1, 'centro', '18000-000', 'AP01', 'Rua Sergipe', '1234', 1, 1);
insert into tb_endereco (id, bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) values (2, 'centro', '18000-000', 'AP02', 'Rua Nordeste', '2233', 2, 2);
insert into tb_endereco (id, bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) values (3, 'centro', '18000-000', 'AP01', 'Rua Alagoas', '1255', 2, 3);

insert into tb_telefone (cliente_id, telefones) values (1, '9999-1111');
insert into tb_telefone (cliente_id, telefones) values (2, '9999-2222');

insert into tb_pedido (id, instante, cliente_id, endereco_entrega_id) values (1, '2023-03-16 15:07:19', 1, 1);
insert into tb_pedido (id, instante, cliente_id, endereco_entrega_id) values (2, '2023-03-16 18:07:19', 2, 2);

insert into tb_pagamento (pedido_id, estado) values (1, 0);

insert into tb_pagamento_cartao (numero_de_parcelas, pedido_id) values (10, 1);

insert into tb_pagamento_boleto (data_pagamento, data_vencimento, pedido_id) values ('2023-03-16 15:07:19', '2023-04-16 15:07:19', 1);









