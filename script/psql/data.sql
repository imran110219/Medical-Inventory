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
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (id, name, phone, address) FROM stdin;
1	Maruf Hossain	01911202020	Dhaka
2	Ali Hasan	01711303030	Dhaka
3	Mohiuddin Jahangir	01811404040	Dhaka
4	Ali Banat	01611808080	Dhaka
\.


--
-- Data for Name: purchase_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchase_invoice (id, supplier_id, total, vat, discount, payable, paid, returned, datetime) FROM stdin;
PI1618989514455	2	760	19	5	774	800	26	2017-01-09 15:26:13
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
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sale (id, sale_invoice_id, stock_id, quantity, unit_price, discount, total, datetime) FROM stdin;
1	SI1618989514455	1	1	10	0	10	2021-02-02 15:28:26
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
-- PostgreSQL database dump complete
--

