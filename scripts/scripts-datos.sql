-- inventario base 


insert into inventory.items values ( 2, 2, 'Computador i5' , 0 , 0, 0, 2000000, 1);
insert into inventory.items values ( 3, 3, 'Computador i7' , 0 , 0, 0, 2500000, 1);
insert into inventory.items values ( 4, 4, 'Monitor 23"' , 0 , 0, 0, 800000, 1);
insert into inventory.items values ( 5, 5, 'Disco Duro SSD 500gb' , 0 , 0, 0, 600000, 1);

insert into inventory.type_doc values (1, 'EN', 'Entrada');
insert into inventory.type_doc values (2, 'SA', 'Salida');


INSERT INTO `inventory`.`warehouses`(`warehouses_Id`,`code`,`name`,`isActived`) VALUES(1 , '001','Principal',1);

-- select * from inventory.document;

insert into inventory.document values ( 1, 1, '000000001', current_date());
insert into inventory.document values ( 2, 1, '000000002', current_date());
insert into inventory.document values ( 3, 2, '000000003', current_date());
insert into inventory.document values ( 4, 2, '000000004', current_date());

INSERT INTO `inventory`.`document_detail`(`document_datail_Id`,`document_id`,`Quantity`,`warehouses_Id`,`itemId`)
-- VALUES(<{document_datail_Id: }>,<{document_id: }>,<{Quantity: }>,<{warehouses_Id: }>,<{itemId: }>);
VALUES (1, 1, 2, 1, 1) , (2,2, 1 ,1, 2), (3, 3, 5 , 1, 3) , (4, 4, 3, 1, 4);


-- Verificación
SELECT d.consecutive,
			td.name tipo_movimiento,
            d.document_date fecha,
            it.code + ' ' + it.name articulo,
            dd.Quantity cantidad,
            wa.name bodega 
            FROM inventory.document d 
inner join inventory.type_doc td on d.type_doc_Id = td.type_doc_Id
inner join inventory.document_detail dd on d.document_id = dd.document_id
inner join inventory.warehouses wa on dd.warehouses_id = wa.warehouses_id
inner join inventory.items it on it.itemId = dd.itemId

