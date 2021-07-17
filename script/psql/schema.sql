--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: app_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_user (
    id integer NOT NULL,
    firstname character varying(100) NOT NULL,
    lastname character varying(100) NOT NULL,
    username character varying(40) NOT NULL,
    email character varying(40) NOT NULL,
    password character varying(200) NOT NULL,
    phone character varying(100) NOT NULL,
    address text NOT NULL,
    active boolean
);


ALTER TABLE public.app_user OWNER TO postgres;

--
-- Name: box; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.box (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.box OWNER TO postgres;

--
-- Name: box_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.box_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.box_seq OWNER TO postgres;

--
-- Name: brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.brand (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    strength character varying(100) NOT NULL,
    dosage_form_id integer NOT NULL,
    generic_id integer NOT NULL,
    manufacturer_id integer NOT NULL,
    purchase_price double precision NOT NULL,
    sale_price double precision NOT NULL
);


ALTER TABLE public.brand OWNER TO postgres;

--
-- Name: brand_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.brand_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.brand_seq OWNER TO postgres;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id integer,
    fullname character varying(100) NOT NULL,
    phone character varying(100) DEFAULT NULL::character varying,
    email character varying(40) DEFAULT NULL::character varying,
    address text
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: dosage_form; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dosage_form (
    id integer NOT NULL,
    name character varying(200) NOT NULL
);


ALTER TABLE public.dosage_form OWNER TO postgres;

--
-- Name: dosage_form_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dosage_form_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dosage_form_seq OWNER TO postgres;

--
-- Name: generic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.generic (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description text
);


ALTER TABLE public.generic OWNER TO postgres;

--
-- Name: generic_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.generic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.generic_seq OWNER TO postgres;

--
-- Name: indication; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.indication (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description text
);


ALTER TABLE public.indication OWNER TO postgres;

--
-- Name: indication_generic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.indication_generic (
    id integer NOT NULL,
    indication_id integer NOT NULL,
    generic_id integer NOT NULL
);


ALTER TABLE public.indication_generic OWNER TO postgres;

--
-- Name: indication_generic_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.indication_generic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indication_generic_seq OWNER TO postgres;

--
-- Name: indication_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.indication_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indication_seq OWNER TO postgres;

--
-- Name: location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    id integer NOT NULL,
    name character varying(200) NOT NULL
);


ALTER TABLE public.location OWNER TO postgres;

--
-- Name: location_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.location_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.location_seq OWNER TO postgres;

--
-- Name: manufacturer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manufacturer (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    address text
);


ALTER TABLE public.manufacturer OWNER TO postgres;

--
-- Name: manufacturer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.manufacturer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.manufacturer_seq OWNER TO postgres;

--
-- Name: purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchase (
    id integer NOT NULL,
    brand_id integer NOT NULL,
    purchase_invoice_id character varying(15) NOT NULL,
    batch_no character varying(15) NOT NULL,
    box_id integer NOT NULL,
    quantity integer NOT NULL,
    unit_price double precision,
    discount double precision,
    total double precision NOT NULL,
    expiry_datetime timestamp(0) without time zone NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.purchase OWNER TO postgres;

--
-- Name: purchase_invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchase_invoice (
    id character varying(15) NOT NULL,
    supplier_id integer,
    total double precision NOT NULL,
    vat double precision NOT NULL,
    discount double precision NOT NULL,
    payable double precision NOT NULL,
    paid double precision NOT NULL,
    returned double precision NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.purchase_invoice OWNER TO postgres;

--
-- Name: purchase_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchase_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchase_seq OWNER TO postgres;

--
-- Name: returned; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.returned (
    id integer NOT NULL,
    sale_id integer,
    purchase_id integer,
    quantity integer NOT NULL,
    unit_price double precision NOT NULL,
    deduction double precision,
    total double precision,
    wastage boolean NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.returned OWNER TO postgres;

--
-- Name: returned_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.returned_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.returned_seq OWNER TO postgres;

--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_seq OWNER TO postgres;

--
-- Name: sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sale (
    id integer NOT NULL,
    sale_invoice_id character varying(15) NOT NULL,
    stock_id integer NOT NULL,
    quantity integer NOT NULL,
    unit_price double precision NOT NULL,
    discount double precision NOT NULL,
    total double precision NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.sale OWNER TO postgres;

--
-- Name: sale_invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sale_invoice (
    id character varying(15) NOT NULL,
    user_id integer NOT NULL,
    total double precision NOT NULL,
    vat double precision NOT NULL,
    discount double precision NOT NULL,
    payable double precision NOT NULL,
    paid double precision NOT NULL,
    returned double precision NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.sale_invoice OWNER TO postgres;

--
-- Name: sale_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sale_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sale_seq OWNER TO postgres;

--
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock (
    id integer NOT NULL,
    purchase_id integer NOT NULL,
    location_id integer,
    quantity integer NOT NULL,
    datetime timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- Name: stock_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stock_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stock_seq OWNER TO postgres;

--
-- Name: supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    id integer NOT NULL,
    name character varying(500) NOT NULL,
    phone character varying(15) DEFAULT NULL::character varying,
    address text
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- Name: supplier_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplier_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supplier_seq OWNER TO postgres;

--
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    id integer NOT NULL,
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- Name: user_role_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_role_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_seq OWNER TO postgres;

--
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_seq OWNER TO postgres;

--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);


--
-- Name: box box_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.box
    ADD CONSTRAINT box_pkey PRIMARY KEY (id);


--
-- Name: brand brand_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (id);


--
-- Name: dosage_form dosage_form_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dosage_form
    ADD CONSTRAINT dosage_form_pkey PRIMARY KEY (id);


--
-- Name: generic generic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generic
    ADD CONSTRAINT generic_pkey PRIMARY KEY (id);


--
-- Name: indication_generic indication_generic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.indication_generic
    ADD CONSTRAINT indication_generic_pkey PRIMARY KEY (id);


--
-- Name: indication indication_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.indication
    ADD CONSTRAINT indication_pkey PRIMARY KEY (id);


--
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- Name: manufacturer manufacturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manufacturer
    ADD CONSTRAINT manufacturer_pkey PRIMARY KEY (id);


--
-- Name: purchase_invoice purchase_invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase_invoice
    ADD CONSTRAINT purchase_invoice_pkey PRIMARY KEY (id);


--
-- Name: purchase purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id);


--
-- Name: returned returned_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.returned
    ADD CONSTRAINT returned_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: sale_invoice sale_invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_invoice
    ADD CONSTRAINT sale_invoice_pkey PRIMARY KEY (id);


--
-- Name: sale sale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id);


--
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);


--
-- Name: supplier supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (id);


--
-- Name: user_role user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (id);


--
-- Name: dosage_form_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX dosage_form_id ON public.brand USING btree (dosage_form_id);


--
-- Name: generic_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX generic_id ON public.indication_generic USING btree (generic_id);


--
-- Name: indication_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX indication_id ON public.indication_generic USING btree (indication_id);


--
-- Name: manufacturer_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX manufacturer_id ON public.brand USING btree (manufacturer_id);


--
-- Name: purchase_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX purchase_id ON public.returned USING btree (purchase_id);


--
-- Name: sale_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX sale_id ON public.returned USING btree (sale_id);


--
-- Name: sale_invoice_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX sale_invoice_id ON public.sale USING btree (sale_invoice_id);


--
-- Name: stock_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX stock_id ON public.sale USING btree (stock_id);


--
-- Name: supplier_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX supplier_id ON public.purchase_invoice USING btree (supplier_id);


--
-- Name: user_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX user_id ON public.sale_invoice USING btree (user_id);


--
-- Name: brand brand_fk_dosage_form; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_fk_dosage_form FOREIGN KEY (dosage_form_id) REFERENCES public.dosage_form(id);


--
-- Name: brand brand_fk_generic; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_fk_generic FOREIGN KEY (generic_id) REFERENCES public.generic(id);


--
-- Name: brand brand_fk_manufacturer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES public.manufacturer(id);


--
-- Name: indication_generic indication_generic_fk_generic; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.indication_generic
    ADD CONSTRAINT indication_generic_fk_generic FOREIGN KEY (generic_id) REFERENCES public.generic(id);


--
-- Name: indication_generic indication_generic_fk_indication; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.indication_generic
    ADD CONSTRAINT indication_generic_fk_indication FOREIGN KEY (indication_id) REFERENCES public.indication(id);


--
-- Name: purchase purchase_fk_brand; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_fk_brand FOREIGN KEY (brand_id) REFERENCES public.brand(id);


--
-- Name: purchase purchase_fk_purchase_invoice; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_fk_purchase_invoice FOREIGN KEY (purchase_invoice_id) REFERENCES public.purchase_invoice(id);


--
-- Name: purchase_invoice purchase_invoice_fk_supplier; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase_invoice
    ADD CONSTRAINT purchase_invoice_fk_supplier FOREIGN KEY (supplier_id) REFERENCES public.supplier(id);


--
-- Name: returned returned_fk_purchase; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.returned
    ADD CONSTRAINT returned_fk_purchase FOREIGN KEY (purchase_id) REFERENCES public.purchase(id);


--
-- Name: returned returned_fk_sale; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.returned
    ADD CONSTRAINT returned_fk_sale FOREIGN KEY (sale_id) REFERENCES public.sale(id);


--
-- Name: sale sale_fk_sale_invoice; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_fk_sale_invoice FOREIGN KEY (sale_invoice_id) REFERENCES public.sale_invoice(id);


--
-- Name: sale sale_fk_stock; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_fk_stock FOREIGN KEY (stock_id) REFERENCES public.stock(id);


--
-- Name: sale_invoice sale_invoice_fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sale_invoice
    ADD CONSTRAINT sale_invoice_fk_user FOREIGN KEY (user_id) REFERENCES public.app_user(id);


--
-- Name: stock stock_fk_location; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_fk_location FOREIGN KEY (location_id) REFERENCES public.purchase(id);


--
-- Name: stock stock_fk_purchase; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_fk_purchase FOREIGN KEY (purchase_id) REFERENCES public.purchase(id);


--
-- Name: user_role user_role_fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_fk_role FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: user_role user_role_fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_fk_user FOREIGN KEY (user_id) REFERENCES public.app_user(id);


--
-- PostgreSQL database dump complete
--

