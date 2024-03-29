INSERT INTO brands (name, website, hq_address) VALUES ('Hexagon', 'https://hexagon.com/fr/company', 'Lilla Bantorget 15 SE-111 23 Stockholm, Sweden');
INSERT INTO brands (name, website, hq_address) VALUES ('Mitutoyo', 'https://www.mitutoyo.fr/fr_fr', '20-1 Sakado 1-Chome, Takatsu-ku, Kawasaki-shi, Kanagawa 213-8533, Japan');
INSERT INTO brands (name, website, hq_address) VALUES ('Keyence', 'https://www.keyence.fr', '1-3-14, Higashi-Nakajima, Higashi-Yodogawa-ku, Osaka, Japan');
INSERT INTO brands (name, website, hq_address) VALUES ('Zeiss', 'https://www.zeiss.fr/corporate/home.html', 'Carl-Zeiss-Straße 22, Oberkochen, Germany');

INSERT INTO factories (name, type, address) VALUES ('Diginetic', 'WORKSHOP', '63 Ridge Boulevard, National, Georgia');
INSERT INTO factories (name, type, address) VALUES ('Infotrips', 'SITE', '3 Rock Street, Cuylerville, Yugoslavia');
INSERT INTO factories (name, type, address) VALUES ('Qualitern', 'WORKSHOP', '33 Fleet Street, Wacissa, Congo');
INSERT INTO factories (name, type, address) VALUES ('Martgo', 'SITE', '90 Rochester Avenue, Vallonia, France, Metropolitan');
INSERT INTO factories (name, type, address) VALUES ('Sultraxin', 'SITE', '98 Belmont Avenue, Saranap, Guatemala');
INSERT INTO factories (name, type, address) VALUES ('Accufarm', 'SITE', '31 Granite Street, Torboy, Honduras');
INSERT INTO factories (name, type, address) VALUES ('Exotechno', 'WORKSHOP', '50 Micieli Place, Rossmore, Aruba');
INSERT INTO factories (name, type, address) VALUES ('Eventage', 'FACTORY', '51 Congress Street, Barstow, Heard and McDonald Islands');
INSERT INTO factories (name, type, address) VALUES ('Shopabout', 'SITE', '6 Laurel Avenue, Fredericktown, Anguilla');
INSERT INTO factories (name, type, address) VALUES ('Virxo', 'SITE', '45 Church Lane, Lund, Greece');
INSERT INTO factories (name, type, address) VALUES ('Dognost', 'FACTORY', '29 Pine Street, Foxworth, Liechtenstein');
INSERT INTO factories (name, type, address) VALUES ('Oronoko', 'FACTORY', '50 Stillwell Avenue, Enoree, Belarus');
INSERT INTO factories (name, type, address) VALUES ('Ultrasure', 'SITE', '20 Elm Avenue, Ryderwood, Bangladesh');
INSERT INTO factories (name, type, address) VALUES ('Niquent', 'SITE', '99 Menahan Street, Oretta, Gabon');
INSERT INTO factories (name, type, address) VALUES ('Schneider', 'FACTORY', 'Mastertech à Moirans');

INSERT INTO models (name, type, brand_id) VALUES ('Quantum Vision', 'VISION', 3);
INSERT INTO models (name, type, brand_id) VALUES ('IM-8000', 'VISION', 3);
INSERT INTO models (name, type, brand_id) VALUES ('Série XM', 'CMM', 3);
INSERT INTO models (name, type, brand_id) VALUES ('Absolute Arm', 'CMM', 1);
INSERT INTO models (name, type, brand_id) VALUES ('OPTIV Reference', 'VISION', 1);
INSERT INTO models (name, type, brand_id) VALUES ('TIGO SF', 'CMM', 1);
INSERT INTO models (name, type, brand_id) VALUES ('GLOBAL', 'CMM', 1);
INSERT INTO models (name, type, brand_id) VALUES ('CV-Series', 'SURFACE', 2);
INSERT INTO models (name, type, brand_id) VALUES ('SurfTest', 'SURFACE', 2);
INSERT INTO models (name, type, brand_id) VALUES ('Quick Vision', 'VISION', 2);
INSERT INTO models (name, type, brand_id) VALUES ('Crysta-Apex V', 'CMM', 2);
INSERT INTO models (name, type, brand_id) VALUES ('Contura', 'CMM', 4);
INSERT INTO models (name, type, brand_id) VALUES ('DuraMax', 'CMM', 4);
INSERT INTO models (name, type, brand_id) VALUES ('O-Inspect', 'VISION', 4);

INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, '7fe0ae86-2e61-4264-a3d0-f456a3548872', true, 6, '2014-06-22T18:19:30.933Z', '2016-12-24T18:19:30.933Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (8, '4434049b-bbf5-4ca3-81d3-77b7ef17dad8', false, 4, '2014-11-06T05:16:41.518Z', '2017-11-20T05:16:41.518Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, '1ed08b0c-b795-4b8d-877d-e8823a1b878b', true, 2, '2018-04-18T04:06:24.017Z', '2019-05-29T04:06:24.017Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, 'd400f302-c1d7-43f9-90fd-08acaaf3a1a0', false, 5, '2014-01-16T07:38:25.109Z', '2015-10-06T07:38:25.109Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, 'e22ae1a1-797f-4390-b276-99ca3370e80c', false, 4, '2017-06-09T00:11:11.479Z', '2020-03-29T00:11:11.479Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (1, '01ba9b92-e940-4858-8df9-caf1fcc5cbb4', true, 8, '2017-03-27T11:42:34.536Z', '2020-03-15T11:42:34.536Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, '44e7bc14-a3fc-4742-8055-e54b739f5901', true, 12, '2018-03-13T07:29:31.626Z', '2021-02-17T07:29:31.626Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (10, '4785086c-7222-4619-ae84-34f31e8ae816', false, 12, '2019-02-09T04:59:49.952Z', '2021-12-29T04:59:49.952Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (7, '440b77ed-60cb-48d6-b72d-7036529c0ab1', false, 5, '2019-09-20T02:03:14.658Z', '2022-03-14T02:03:14.658Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, 'a5d33a84-0943-402f-a1f3-8e146d22fbca', false, 8, '2020-11-29T12:41:39.362Z', null, 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (4, '6aa99a42-1f70-4fd8-b4e0-1c9ad9dc998d', false, 14, '2013-01-10T13:42:21.201Z', '2014-06-03T13:42:21.201Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (8, '2661ba23-e5b9-4012-8fc4-903384198e4a', false, 8, '2018-04-15T00:46:48.940Z', '2019-10-20T00:46:48.940Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (12, '8d7c2936-cc8c-404c-8fc5-f77a72a9db8d', false, 14, '2016-04-27T04:44:33.793Z', '2017-06-16T04:44:33.793Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, '4661045b-052f-4e24-8d05-fe175be1593e', true, 2, '2021-06-14T03:45:13.192Z', null, 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (5, '3a649c49-1ae9-4774-af54-359beb4c9c40', false, 1, '2019-11-05T09:44:09.270Z', '2021-12-16T09:44:09.270Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, '6907b286-2e67-44e6-b15e-d37e46524138', false, 14, '2014-03-19T17:15:29.545Z', '2015-08-26T17:15:29.545Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (1, '79740bd4-17d9-4f2f-8abc-22c13cd77e47', false, 14, '2014-12-16T03:25:20.404Z', '2017-08-04T03:25:20.404Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, '7dfa55aa-dab8-4781-8aab-04cc1e2e3f16', false, 13, '2022-08-28T16:56:56.084Z', null, 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, 'cdf4c3f0-1f13-4c7f-a3f6-a3ac016884af', true, 5, '2015-11-11T10:02:25.583Z', '2017-08-04T10:02:25.583Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, 'b1cd4a80-9517-4e09-b5a8-cf5cc6935760', true, 14, '2022-11-13T15:27:41.339Z', null, 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, 'dd258248-2d4f-4f1f-9323-b21b787b914b', false, 8, '2019-01-21T04:52:24.724Z', '2021-04-30T04:52:24.724Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (8, '9c36b0f1-3301-45c1-899f-3b669961f317', false, 13, '2013-11-10T12:52:17.971Z', '2015-08-25T12:52:17.971Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, '09297405-85ed-4533-9fd0-2142194b301d', false, 3, '2019-05-17T15:21:46.447Z', '2021-09-08T15:21:46.447Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (8, '8afa6e7e-fc5b-40c3-933b-452ff1556406', false, 9, '2016-05-14T04:10:49.499Z', '2018-06-22T04:10:49.499Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (7, 'f1a367f1-9500-4a61-afed-3622945b4589', false, 4, '2018-06-27T13:18:06.134Z', '2021-05-30T13:18:06.134Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (10, '857f6756-5fa4-4400-9d15-ed9838463d23', false, 5, '2016-08-11T12:05:07.231Z', '2018-11-15T12:05:07.231Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, '1c760cf0-859e-428e-a2a0-2bbc6b320df9', false, 6, '2017-04-23T22:07:41.154Z', '2019-11-24T22:07:41.154Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, '3f71b0ab-9a8c-4a43-ba03-47550811a033', false, 6, '2016-03-11T06:07:08.677Z', '2018-03-30T06:07:08.677Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, 'bd1feabe-1487-4a02-8a63-cfd044493fbb', false, 8, '2022-12-31T03:36:27.428Z', null, 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, '20187f60-0447-4ff7-a89c-69dbe15cc7eb', false, 13, '2020-04-17T09:09:10.631Z', '2022-05-20T09:09:10.631Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (1, '6ed0c0f8-ef56-46e8-878b-1b13138e75ad', false, 1, '2020-05-12T14:30:26.653Z', '2021-07-16T14:30:26.653Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, 'e1a5e0bd-fe2f-47cf-a2c9-30fa73f22374', true, 9, '2019-12-18T10:48:58.257Z', '2022-07-26T10:48:58.257Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (13, '09b4747e-7245-4c6c-b211-17e7e8fa6af5', true, 12, '2020-06-08T08:21:08.410Z', '2021-09-20T08:21:08.410Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (5, 'd3d31632-5415-4cb1-ac8d-a961d58679a1', false, 7, '2014-05-20T16:13:56.758Z', '2017-04-26T16:13:56.758Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (11, '75da12c6-4045-4ddd-9910-583d63f1935c', true, 7, '2016-06-09T03:20:28.817Z', '2018-07-31T03:20:28.817Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, '2dd7440c-9051-4eb5-b83f-5f9927980cf5', true, 11, '2017-07-07T08:24:44.107Z', '2020-05-25T08:24:44.107Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (7, '6a6c5132-2dd5-4e33-aa52-e1a551bf597a', false, 12, '2015-06-26T11:11:00.654Z', '2018-04-11T11:11:00.654Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, '7f901a12-6aaf-4b49-9f5f-e22b2a1ad759', false, 3, '2019-09-13T11:19:53.189Z', '2022-08-30T11:19:53.189Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, 'c338d09f-f70e-4f8d-a8b7-c7814c3d1e54', true, 7, '2021-06-25T15:43:54.099Z', null, 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (11, 'd41e983b-47a5-42a7-ab54-d8ad55712e15', false, 11, '2019-06-11T14:02:41.087Z', '2021-12-16T14:02:41.087Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (7, 'b8587437-c3ac-427e-b22d-5c33315ad99f', false, 11, '2015-12-25T11:35:03.978Z', '2018-08-08T11:35:03.978Z', 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, '7cb9dee0-4df6-45d9-80f0-f9c79174276a', true, 2, '2016-10-16T10:04:15.420Z', '2019-06-21T10:04:15.420Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, '6f322ae9-0d2f-44dc-8d70-f38b519797fd', false, 6, '2020-11-20T23:09:11.481Z', '2022-01-30T23:09:11.481Z', 'IDLE');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (1, 'f88ab601-647b-41a9-beee-7874c9699896', false, 4, '2022-05-13T01:01:43.034Z', null, 'RUNNING');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, '881fc17f-f471-4d66-b57b-80374d069bed', false, 12, '2013-09-27T00:35:39.249Z', '2014-11-16T00:35:39.249Z', 'OFF');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (13, 'a2edec5b-dda5-4ea7-815d-84c9646eefe0', false, 4, '2014-09-06T04:04:35.871Z', '2016-06-18T04:04:35.871Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, '03568fc8-96e3-4dea-9aab-26e6391a5db0', false, 7, '2017-10-09T15:01:54.953Z', '2019-11-23T15:01:54.953Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (13, '5c8ad8d1-c501-44c4-9162-1ee2a2dd530c', false, 12, '2019-06-03T04:22:37.230Z', '2022-04-11T04:22:37.230Z', 'STOP');
INSERT INTO machines (model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, 'b65eb5c3-be65-487b-9ac8-4e4748de9a24', true, 5, '2014-05-08T09:44:31.216Z', '2016-10-23T09:44:31.216Z', 'STOP');

INSERT INTO pc_constraints (name, code, type) VALUES ('Socket', 'SOCKET', 'SAME');
INSERT INTO pc_constraints (name, code, type) VALUES ('Chipset', 'CHIPSET', 'SAME');
INSERT INTO pc_constraints (name, code, type) VALUES ('Motherboard Size', 'MOBO_SIZE', 'SAME');
INSERT INTO pc_constraints (name, code, type) VALUES ('Cooling fan max length', 'COOLING_FAN_MAX_LENGTH', 'MAX');
INSERT INTO pc_constraints (name, code, type) VALUES ('AIO fan size', 'AIO_FAN_SIZE', 'SAME');
INSERT INTO pc_constraints (name, code, type) VALUES ('3.5" capacity', '3_5_CAPACITY', 'CAPACITY');
INSERT INTO pc_constraints (name, code, type) VALUES ('2.5" capacity', '2_5_CAPACITY', 'CAPACITY');
INSERT INTO pc_constraints (name, code, type) VALUES ('GPU max length', 'GPU_MAX_LENGTH', 'MAX');
INSERT INTO pc_constraints (name, code, type) VALUES ('GPU length', 'GPU_MAX_LENGTH', 'LIMIT');
INSERT INTO pc_constraints (name, code, type) VALUES ('GPU power', 'POWER', 'LIMIT');
INSERT INTO pc_constraints (name, code, type) VALUES ('RAM frequency', 'RAM_FREQUENCY', 'SAME');
INSERT INTO pc_constraints (name, code, type) VALUES ('SSD M.2 capacity', 'SSD_M_2_CAPACITY', 'CAPACITY');
INSERT INTO pc_constraints (name, code, type) VALUES ('Power', 'POWER', 'MAX');

INSERT INTO pc_specifications (name, code) VALUES ('CPU frequency', 'CPU_FREQUENCY');
INSERT INTO pc_specifications (name, code) VALUES ('Number of cores', 'NUMBER_OF_CORE');
INSERT INTO pc_specifications (name, code) VALUES ('GPU memory', 'GPU_MEMORY');
INSERT INTO pc_specifications (name, code) VALUES ('Norme 80 PLUS', 'NORME_80_PLUS');
INSERT INTO pc_specifications (name, code) VALUES ('Number of RAM', 'NUMBER_OF_RAM');
INSERT INTO pc_specifications (name, code) VALUES ('RAM memory', 'RAM_MEMORY');

INSERT INTO pc_element_types (name, code) VALUES ('CPU', 'CPU');
INSERT INTO pc_element_types (name, code) VALUES ('Case', 'CASE');
INSERT INTO pc_element_types (name, code) VALUES ('GPU', 'GPU');
INSERT INTO pc_element_types (name, code) VALUES ('Motherboard', 'MOBO');
INSERT INTO pc_element_types (name, code) VALUES ('RAM', 'RAM');
INSERT INTO pc_element_types (name, code) VALUES ('Power supply', 'POWER');
INSERT INTO pc_element_types (name, code) VALUES ('Storage', 'STORAGE');
INSERT INTO pc_element_types (name, code) VALUES ('Cooling system', 'COOLING');

INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Intel', 'i5-12400F', 184.96, 'https://media.ldlc.com/r374/ld/products/00/05/91/49/LD0005914928_1.jpg', 1);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Intel', 'i7-12700KF', 379.96, null, 1);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('AMD', 'Ryzen 5 3600', 77.95, null, 1);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('AMD', 'Ryzen 5 7600X', 279.95, null, 1);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('AMD', 'Ryzen 7 5800X', 224.95, null, 1);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Corsair', '4000D AIRFLOW TG', 109.96, null, 2);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('be quiet!', 'Pure Base 500DX', 119.95, null, 2);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Nvidia', 'MSI GeForce RTX 4060', 349.96, null, 3);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Nvidia', 'Gainward GeForce RTX 4070', 649.94, null, 3);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('MSI', 'PRO Z790-P', 249.95, null, 4);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Gigabyte', 'B550M AORUS ELITE', 123.95, null, 4);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('be quiet!', 'Pure Power 12 M 650W 80PLUS Gold', 116.95, null, 6);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('MSI', 'MAG A850GL PCIE5', 129.95, null, 6);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('G.Skill', 'Aegis 16 Go (2 x 8 Go) DDR4 3200 MHz CL16', 56.95, null, 5);
INSERT INTO pc_elements (brand, model, price, img, element_type_id) VALUES ('Corsair', 'Vengeance DDR5 32 Go (2 x 16 Go) 4800 MHz CL40', 134.95, null, 5);

INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (1, 1); -- CPU/Socket
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (1, 2); -- CPU/Chipset
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 3); -- Case/Motherboard Size
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 4); -- Case/Cooling fan max length
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 5); -- Case/AIO fan size
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 6); -- Case/3.5" capacity
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 7); -- Case/2.5" capacity
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (2, 8); -- Case/GPU max length
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (3, 9); -- GPU/GPU length
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (3, 10); -- GPU/GPU power
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (4, 1); -- MOBO/Socket
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (4, 2); -- MOBO/Chipset
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (4, 3); -- MOBO/Motherboard Size
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (4, 11); -- MOBO/RAM frequency
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (4, 12); -- MOBO/SSD M.2 capacity
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (6, 13); -- POWER/Power
INSERT INTO pc_element_types_constraints (element_type_id, constraint_id) VALUES (5, 11); -- RAM/RAM frequency

INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (1, 1, '1700');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (1, 2, 'B660');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (1, 2, 'Z790');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (2, 1, '1700');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (2, 2, 'B660');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (2, 2, 'Z790');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (3, 1, 'AM4');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (3, 2, 'B550');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (4, 1, 'AM5');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (4, 2, 'X670');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (5, 1, 'AM4');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (5, 2, 'B550');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 3, 'ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 3, 'E_ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 3, 'MICRO_ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 4, '170');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 5, '120');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 6, '2');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 7, '2');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (6, 8, '360');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 3, 'ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 3, 'MICRO_ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 4, '190');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 5, '120');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 5, '140');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 6, '2');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 7, '5');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (7, 8, '369');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (8, 9, '199');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (8, 10, '115');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (9, 9, '369.1');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (9, 10, '200');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (10, 3, 'ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (10, 1, '1700');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (10, 2, 'Z790');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (10, 11, '4800');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (10, 12, '4');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 3, 'MICRO_ATX');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 1, 'AM4');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 2, 'B550');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 11, '2666');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 11, '2933');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 11, '3200');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 11, '3600');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (11, 12, '2');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (12, 13, '650');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (13, 13, '850');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (14, 11, '3200');
INSERT INTO pc_elements_constraints (element_id, constraint_id, c_value) VALUES (15, 11, '4800');

INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (1, 1); -- CPU/CPU frequency
INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (1, 2); -- CPU/Number of cores
INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (3, 3); -- GPU/GPU memory
INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (6, 4); -- POWER/Norme 80 PLUS
INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (5, 5); -- RAM/Number of RAM
INSERT INTO pc_element_types_specifications (element_type_id, specification_id) VALUES (5, 6); -- RAM/RAM memory

INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (1, 1, '2.5');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (1, 2, '6');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (2, 1, '3.6');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (2, 2, '12');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (3, 1, '3.6');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (3, 2, '6');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (4, 1, '4.7');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (4, 2, '6');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (5, 1, '3.8');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (5, 2, '8');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (8, 3, '8');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (9, 3, '12');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (12, 4, '80 PLUS Gold');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (13, 4, '80 PLUS Gold');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (14, 5, '2');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (14, 6, '8');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (15, 5, '2');
INSERT INTO pc_elements_specifications (element_id, specification_id, s_value) VALUES (15, 6, '16');
