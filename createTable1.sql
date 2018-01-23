CREATE TABLE localidades (
    localidade_ID BIGINT PRIMARY KEY NOT NULL, 
    nomeCidade VARCHAR(255) NOT NULL, 
    UF VARCHAR(2) NOT NULL
);

CREATE TABLE aeronaves (
    aeronave_ID BIGINT PRIMARY KEY NOT NULL, 
    modelo VARCHAR(100) NOT NULL, 
    capacidade BIGINT NOT NULL
);

CREATE TABLE voos (
    voo_ID BIGINT PRIMARY KEY NOT NULL, 
    mLocalOrigem BIGINT, 
    mLocalDestino BIGINT, 
    mAeronave BIGINT, 
    portao varchar(32), 
    horario timestamp NOT NULL, 
    FOREIGN KEY (mLocalOrigem) REFERENCES localidades (localidade_ID), 
    FOREIGN KEY (mLocalDestino) REFERENCES localidades (localidade_ID), 
    FOREIGN KEY (mAeronave) REFERENCES aeronaves (aeronave_ID)
);

CREATE TABLE passagens (
    passagem_ID BIGINT PRIMARY KEY NOT NULL, 
    mVoo BIGINT, 
    poltrona BIGINT NOT NULL, 
    nome varchar (255) NOT NULL, 
    cpf varchar (32) NOT NULL, 
    FOREIGN KEY(mVoo) REFERENCES voos (voo_ID)
);