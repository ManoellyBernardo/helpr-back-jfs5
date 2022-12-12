    SELECT * FROM cargo;

    CREATE DATABASE helper_bkp;

    CREATE TABLE helper_bkp.cargobkp(
        id_cargo INTEGER PRIMARY KEY AUTO_INCREMENT ,
        nome VARCHAR(150) NOT NULL,
        descricao VARCHAR(150) NOT NULL,
        salario DECIMAL(10,2) NOT NULL
  );




    DELIMITER //

    CREATE TRIGGER tg_bkp_cargos
    BEFORE DELETE ON cargo
    FOR EACH ROW
    BEGIN
    INSERT INTO helper_bkp.cargobkp VALUES(OLD.id_cargo, OLD.nome,OLD.descricao, OLD.salario);
    END//




  DELIMITER ;

  DELETE FROM cargo WHERE id_cargo=7;

  SELECT * FROM helper_bkp.cargobkp;