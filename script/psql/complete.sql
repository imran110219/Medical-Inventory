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
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_user (id, firstname, lastname, username, email, password, phone, address, active) FROM stdin;
1	John	Player	john	john@gmail.com	$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG	01912070224	Dhaka	t
2	Sadman	Sobhan	imran	imran@gmail.com	$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG	01912070224	Dhaka	t
3	Md	Amin	amin	amin@gmail.com	$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG	01912070224	Dhaka	t
4	Md	Masud	masud	masud@gmail.com	$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG	01912070224	Dhaka	t
5	Md	Atik	atik	atik@gmail.com	$2a$10$pGv5BjUq367eFin.vgvPeugs3ugRywvlveGVZAdZidkXF2WBa0sHG	013258965	Test	t
6	Md	Rahim	rahim	rahim@gmail.com	$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O	01912070224	Test	t
\.


--
-- Data for Name: box; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.box (id, name, quantity) FROM stdin;
1	1	1
2	20	20
3	40	40
4	60	60
\.


--
-- Data for Name: brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.brand (id, name, strength, dosage_form_id, generic_id, manufacturer_id, purchase_price, sale_price) FROM stdin;
1	1stCef	500 mg	1	1	2	12	20
2	3-C	200 mg	2	2	3	35	50
5	3-F	500 mg	2	2	4	14	30
3	3-D	100 mg/5 ml	3	4	5	195	300
4	3-E	400 mg	1	1	5	20	30
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, fullname, phone, email, address) FROM stdin;
\.


--
-- Data for Name: dosage_form; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dosage_form (id, name) FROM stdin;
1	Capsule
2	Gel
3	IM Injection
4	IV Infusion
5	IV Injection
6	Ophthalmic Ointment
\.


--
-- Data for Name: generic; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.generic (id, name, description) FROM stdin;
1	5-Fluorouracil [5-FU]	\N
2	Abacavir + Lamivudine + Zidovudine	\N
3	Abiraterone Acetate	\N
4	Acarbose	\N
5	Aceclofenac	\N
\.


--
-- Data for Name: indication; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.indication (id, name, description) FROM stdin;
1	Abdominal pain	\N
2	Abortion	\N
3	Abrasion	\N
4	Abscesses	\N
5	Absence seizures	\N
\.


--
-- Data for Name: indication_generic; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.indication_generic (id, indication_id, generic_id) FROM stdin;
1	1	1
2	2	2
3	1	3
4	1	4
5	3	2
\.


--
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (id, name) FROM stdin;
1	Shelf A
2	Shelf B
3	Shelf C
4	Shelf D
5	Shelf E
\.


--
-- Data for Name: manufacturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.manufacturer (id, name, address) FROM stdin;
1	Abbott Laboratories	\N
2	ACI Limited	\N
3	ACME Laboratories Ltd.	\N
4	Ad-din pharmaceuticals Ltd.	\N
5	Aexim Pharmaceuticals Ltd.	\N
\.


--
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchase (id, brand_id, purchase_invoice_id, batch_no, box_id, quantity, unit_price, discount, total, expiry_datetime, datetime) FROM stdin;
1	1	PI1618989514455	B1491729973342	1	10	9	5	90	2022-01-02 15:41:59	2021-02-02 15:22:02
2	2	PI1618989514455	B1491729973342	2	5	100	6	500	2022-01-02 15:41:59	2021-02-02 15:22:02
3	3	PI1618989514455	B1491729973342	3	20	100	6	2000	2022-02-02 15:23:00	2021-02-02 15:22:02
4	4	PI1618989514455	B1491729973342	1	30	100	6	3000	2022-02-02 15:23:23	2021-02-02 15:22:02
5	1	PI1618989514455	B1491729973342	2	20	5	6	100	2022-02-02 15:24:24	2021-02-02 15:22:02
6	3	PI1618989514455	B1491729973342	3	55	6	6	330	2022-02-02 15:25:30	2021-02-02 15:22:02
\.


--
-- Data for Name: purchase_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchase_invoice (id, supplier_id, total, vat, discount, payable, paid, returned, datetime) FROM stdin;
PI1618989514455	2	760	19	5	774	800	26	2017-01-09 15:26:13
\.


--
-- Data for Name: returned; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.returned (id, sale_id, purchase_id, quantity, unit_price, deduction, total, wastage, datetime) FROM stdin;
1	1	\N	5	5	5	555	t	2021-04-24 14:41:14
2	\N	1	5	5	5	555	t	2021-04-24 14:48:30
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name) FROM stdin;
1	SUPER_ADMIN
2	ADMIN
3	USER
\.


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale (id, sale_invoice_id, stock_id, quantity, unit_price, discount, total, datetime) FROM stdin;
1	SI1618989514455	1	1	10	0	10	2021-02-02 15:28:26
\.


--
-- Data for Name: sale_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale_invoice (id, user_id, total, vat, discount, payable, paid, returned, datetime) FROM stdin;
SI1618989514455	2	760	19	5	774	800	26	2017-01-09 15:26:13
\.


--
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stock (id, purchase_id, location_id, quantity, datetime) FROM stdin;
1	1	1	10	2021-02-03 15:41:43
2	2	2	5	2021-02-03 15:42:12
3	3	3	20	2021-02-03 15:42:44
4	4	4	30	2021-02-03 15:43:14
5	5	5	20	2021-02-03 15:43:44
6	6	5	55	2021-02-03 15:44:08
\.


--
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (id, name, phone, address) FROM stdin;
1	Maruf Hossain	01911202020	Dhaka
2	Ali Hasan	01711303030	Dhaka
3	Mohiuddin Jahangir	01811404040	Dhaka
4	Ali Banat	01611808080	Dhaka
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_role (id, user_id, role_id) FROM stdin;
1	1	1
2	2	2
3	3	3
4	4	1
5	5	2
6	6	3
\.


--
-- Name: box_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.box_seq', 4, false);


--
-- Name: brand_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.brand_seq', 6, false);


--
-- Name: dosage_form_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dosage_form_seq', 122, false);


--
-- Name: generic_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.generic_seq', 1499, false);


--
-- Name: indication_generic_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.indication_generic_seq', 8987, false);


--
-- Name: indication_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.indication_seq', 2030, false);


--
-- Name: location_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.location_seq', 6, false);


--
-- Name: manufacturer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.manufacturer_seq', 189, false);


--
-- Name: purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchase_seq', 7, false);


--
-- Name: returned_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.returned_seq', 3, false);


--
-- Name: role_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_seq', 4, false);


--
-- Name: sale_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sale_seq', 2, false);


--
-- Name: stock_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.stock_seq', 7, false);


--
-- Name: supplier_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplier_seq', 5, false);


--
-- Name: user_role_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_role_seq', 7, false);


--
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_seq', 7, false);


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

