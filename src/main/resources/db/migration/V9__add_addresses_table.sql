CREATE TABLE IF NOT EXISTS organisations_schema.addresses
(
    id        UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
    postcode  VARCHAR(10),
    address   VARCHAR(256)
);

ALTER TABLE organisations_schema.organisations
    ADD COLUMN address_id UUID NULL REFERENCES organisations_schema.addresses (id)
;
