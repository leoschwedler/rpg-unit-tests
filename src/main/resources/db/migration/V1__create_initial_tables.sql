CREATE TABLE classe (
                        id        BIGSERIAL PRIMARY KEY,
                        nome      VARCHAR(100) NOT NULL,
                        descricao TEXT
);

CREATE TABLE personagem (
                            id        BIGSERIAL PRIMARY KEY,
                            id_classe BIGINT NOT NULL REFERENCES classe(id),
                            nome      VARCHAR(100) NOT NULL,
                            nivel     INTEGER NOT NULL DEFAULT 1 CHECK (nivel >= 1)
);

CREATE TABLE inventario (
                            id            BIGSERIAL PRIMARY KEY,
                            id_personagem BIGINT NOT NULL UNIQUE REFERENCES personagem(id),
                            quantidade    INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE item (
                      id            BIGSERIAL PRIMARY KEY,
                      id_inventario BIGINT NOT NULL REFERENCES inventario(id),
                      nome          VARCHAR(100) NOT NULL,
                      tipo          VARCHAR(100) NOT NULL,
                      valor         NUMERIC(10,2)
);