INSERT INTO brands (id, name, website, hq_address) VALUES (0, 'Hexagon', 'https://hexagon.com/fr/company', 'Lilla Bantorget 15 SE-111 23 Stockholm, Sweden');
INSERT INTO brands (id, name, website, hq_address) VALUES (1, 'Mitutoyo', 'https://www.mitutoyo.fr/fr_fr', '20-1 Sakado 1-Chome, Takatsu-ku, Kawasaki-shi, Kanagawa 213-8533, Japan');
INSERT INTO brands (id, name, website, hq_address) VALUES (2, 'Keyence', 'https://www.keyence.fr', '1-3-14, Higashi-Nakajima, Higashi-Yodogawa-ku, Osaka, Japan');
INSERT INTO brands (id, name, website, hq_address) VALUES (3, 'Zeiss', 'https://www.zeiss.fr/corporate/home.html', 'Carl-Zeiss-Straße 22, Oberkochen, Germany');

INSERT INTO factories (id, name, type, address) VALUES (0, 'Diginetic', 'WORKSHOP', '63 Ridge Boulevard, National, Georgia');
INSERT INTO factories (id, name, type, address) VALUES (1, 'Infotrips', 'SITE', '3 Rock Street, Cuylerville, Yugoslavia');
INSERT INTO factories (id, name, type, address) VALUES (2, 'Qualitern', 'WORKSHOP', '33 Fleet Street, Wacissa, Congo');
INSERT INTO factories (id, name, type, address) VALUES (3, 'Martgo', 'SITE', '90 Rochester Avenue, Vallonia, France, Metropolitan');
INSERT INTO factories (id, name, type, address) VALUES (4, 'Sultraxin', 'SITE', '98 Belmont Avenue, Saranap, Guatemala');
INSERT INTO factories (id, name, type, address) VALUES (5, 'Accufarm', 'SITE', '31 Granite Street, Torboy, Honduras');
INSERT INTO factories (id, name, type, address) VALUES (6, 'Exotechno', 'WORKSHOP', '50 Micieli Place, Rossmore, Aruba');
INSERT INTO factories (id, name, type, address) VALUES (7, 'Eventage', 'FACTORY', '51 Congress Street, Barstow, Heard and McDonald Islands');
INSERT INTO factories (id, name, type, address) VALUES (8, 'Shopabout', 'SITE', '6 Laurel Avenue, Fredericktown, Anguilla');
INSERT INTO factories (id, name, type, address) VALUES (9, 'Virxo', 'SITE', '45 Church Lane, Lund, Greece');
INSERT INTO factories (id, name, type, address) VALUES (10, 'Dognost', 'FACTORY', '29 Pine Street, Foxworth, Liechtenstein');
INSERT INTO factories (id, name, type, address) VALUES (11, 'Oronoko', 'FACTORY', '50 Stillwell Avenue, Enoree, Belarus');
INSERT INTO factories (id, name, type, address) VALUES (12, 'Ultrasure', 'SITE', '20 Elm Avenue, Ryderwood, Bangladesh');
INSERT INTO factories (id, name, type, address) VALUES (13, 'Niquent', 'SITE', '99 Menahan Street, Oretta, Gabon');
INSERT INTO factories (id, name, type, address) VALUES (14, 'Schneider', 'FACTORY', 'Mastertech à Moirans');

INSERT INTO models (id, name, type, brand_id) VALUES (0, 'Quantum Vision', 'VISION', 2);
INSERT INTO models (id, name, type, brand_id) VALUES (1, 'IM-8000', 'VISION', 2);
INSERT INTO models (id, name, type, brand_id) VALUES (2, 'Série XM', 'CMM', 2);
INSERT INTO models (id, name, type, brand_id) VALUES (3, 'Absolute Arm', 'CMM', 0);
INSERT INTO models (id, name, type, brand_id) VALUES (4, 'OPTIV Reference', 'VISION', 0);
INSERT INTO models (id, name, type, brand_id) VALUES (5, 'TIGO SF', 'CMM', 0);
INSERT INTO models (id, name, type, brand_id) VALUES (6, 'GLOBAL', 'CMM', 0);
INSERT INTO models (id, name, type, brand_id) VALUES (7, 'CV-Series', 'SURFACE', 1);
INSERT INTO models (id, name, type, brand_id) VALUES (8, 'SurfTest', 'SURFACE', 1);
INSERT INTO models (id, name, type, brand_id) VALUES (9, 'Quick Vision', 'VISION', 1);
INSERT INTO models (id, name, type, brand_id) VALUES (10, 'Crysta-Apex V', 'CMM', 1);
INSERT INTO models (id, name, type, brand_id) VALUES (11, 'Contura', 'CMM', 3);
INSERT INTO models (id, name, type, brand_id) VALUES (12, 'DuraMax', 'CMM', 3);
INSERT INTO models (id, name, type, brand_id) VALUES (13, 'O-Inspect', 'VISION', 3);

INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (0, 5, '7fe0ae86-2e61-4264-a3d0-f456a3548872', true, 5, '2014-06-22T18:19:30.933Z', '2016-12-24T18:19:30.933Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (1, 7, '4434049b-bbf5-4ca3-81d3-77b7ef17dad8', false, 3, '2014-11-06T05:16:41.518Z', '2017-11-20T05:16:41.518Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (2, 1, '1ed08b0c-b795-4b8d-877d-e8823a1b878b', true, 1, '2018-04-18T04:06:24.017Z', '2019-05-29T04:06:24.017Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (3, 2, 'd400f302-c1d7-43f9-90fd-08acaaf3a1a0', false, 4, '2014-01-16T07:38:25.109Z', '2015-10-06T07:38:25.109Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (4, 8, 'e22ae1a1-797f-4390-b276-99ca3370e80c', false, 3, '2017-06-09T00:11:11.479Z', '2020-03-29T00:11:11.479Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (5, 0, '01ba9b92-e940-4858-8df9-caf1fcc5cbb4', true, 7, '2017-03-27T11:42:34.536Z', '2020-03-15T11:42:34.536Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (6, 13, '44e7bc14-a3fc-4742-8055-e54b739f5901', true, 11, '2018-03-13T07:29:31.626Z', '2021-02-17T07:29:31.626Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (7, 9, '4785086c-7222-4619-ae84-34f31e8ae816', false, 11, '2019-02-09T04:59:49.952Z', '2021-12-29T04:59:49.952Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (8, 6, '440b77ed-60cb-48d6-b72d-7036529c0ab1', false, 4, '2019-09-20T02:03:14.658Z', '2022-03-14T02:03:14.658Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (9, 1, 'a5d33a84-0943-402f-a1f3-8e146d22fbca', false, 7, '2020-11-29T12:41:39.362Z', null, 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (10, 3, '6aa99a42-1f70-4fd8-b4e0-1c9ad9dc998d', false, 13, '2013-01-10T13:42:21.201Z', '2014-06-03T13:42:21.201Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (11, 7, '2661ba23-e5b9-4012-8fc4-903384198e4a', false, 7, '2018-04-15T00:46:48.940Z', '2019-10-20T00:46:48.940Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (12, 11, '8d7c2936-cc8c-404c-8fc5-f77a72a9db8d', false, 13, '2016-04-27T04:44:33.793Z', '2017-06-16T04:44:33.793Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (13, 5, '4661045b-052f-4e24-8d05-fe175be1593e', true, 1, '2021-06-14T03:45:13.192Z', null, 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (14, 4, '3a649c49-1ae9-4774-af54-359beb4c9c40', false, 0, '2019-11-05T09:44:09.270Z', '2021-12-16T09:44:09.270Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (15, 5, '6907b286-2e67-44e6-b15e-d37e46524138', false, 13, '2014-03-19T17:15:29.545Z', '2015-08-26T17:15:29.545Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (16, 0, '79740bd4-17d9-4f2f-8abc-22c13cd77e47', false, 13, '2014-12-16T03:25:20.404Z', '2017-08-04T03:25:20.404Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (17, 2, '7dfa55aa-dab8-4781-8aab-04cc1e2e3f16', false, 12, '2022-08-28T16:56:56.084Z', null, 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (18, 8, 'cdf4c3f0-1f13-4c7f-a3f6-a3ac016884af', true, 4, '2015-11-11T10:02:25.583Z', '2017-08-04T10:02:25.583Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (19, 13, 'b1cd4a80-9517-4e09-b5a8-cf5cc6935760', true, 13, '2022-11-13T15:27:41.339Z', null, 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (20, 2, 'dd258248-2d4f-4f1f-9323-b21b787b914b', false, 7, '2019-01-21T04:52:24.724Z', '2021-04-30T04:52:24.724Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (21, 7, '9c36b0f1-3301-45c1-899f-3b669961f317', false, 12, '2013-11-10T12:52:17.971Z', '2015-08-25T12:52:17.971Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (22, 1, '09297405-85ed-4533-9fd0-2142194b301d', false, 2, '2019-05-17T15:21:46.447Z', '2021-09-08T15:21:46.447Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (23, 7, '8afa6e7e-fc5b-40c3-933b-452ff1556406', false, 8, '2016-05-14T04:10:49.499Z', '2018-06-22T04:10:49.499Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (24, 6, 'f1a367f1-9500-4a61-afed-3622945b4589', false, 3, '2018-06-27T13:18:06.134Z', '2021-05-30T13:18:06.134Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (25, 9, '857f6756-5fa4-4400-9d15-ed9838463d23', false, 4, '2016-08-11T12:05:07.231Z', '2018-11-15T12:05:07.231Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (26, 1, '1c760cf0-859e-428e-a2a0-2bbc6b320df9', false, 5, '2017-04-23T22:07:41.154Z', '2019-11-24T22:07:41.154Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (27, 13, '3f71b0ab-9a8c-4a43-ba03-47550811a033', false, 5, '2016-03-11T06:07:08.677Z', '2018-03-30T06:07:08.677Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (28, 2, 'bd1feabe-1487-4a02-8a63-cfd044493fbb', false, 7, '2022-12-31T03:36:27.428Z', null, 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (29, 8, '20187f60-0447-4ff7-a89c-69dbe15cc7eb', false, 12, '2020-04-17T09:09:10.631Z', '2022-05-20T09:09:10.631Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (30, 0, '6ed0c0f8-ef56-46e8-878b-1b13138e75ad', false, 0, '2020-05-12T14:30:26.653Z', '2021-07-16T14:30:26.653Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (31, 1, 'e1a5e0bd-fe2f-47cf-a2c9-30fa73f22374', true, 8, '2019-12-18T10:48:58.257Z', '2022-07-26T10:48:58.257Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (32, 12, '09b4747e-7245-4c6c-b211-17e7e8fa6af5', true, 11, '2020-06-08T08:21:08.410Z', '2021-09-20T08:21:08.410Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (33, 4, 'd3d31632-5415-4cb1-ac8d-a961d58679a1', false, 6, '2014-05-20T16:13:56.758Z', '2017-04-26T16:13:56.758Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (34, 10, '75da12c6-4045-4ddd-9910-583d63f1935c', true, 6, '2016-06-09T03:20:28.817Z', '2018-07-31T03:20:28.817Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (35, 5, '2dd7440c-9051-4eb5-b83f-5f9927980cf5', true, 10, '2017-07-07T08:24:44.107Z', '2020-05-25T08:24:44.107Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (36, 6, '6a6c5132-2dd5-4e33-aa52-e1a551bf597a', false, 11, '2015-06-26T11:11:00.654Z', '2018-04-11T11:11:00.654Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (37, 8, '7f901a12-6aaf-4b49-9f5f-e22b2a1ad759', false, 2, '2019-09-13T11:19:53.189Z', '2022-08-30T11:19:53.189Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (38, 5, 'c338d09f-f70e-4f8d-a8b7-c7814c3d1e54', true, 6, '2021-06-25T15:43:54.099Z', null, 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (39, 10, 'd41e983b-47a5-42a7-ab54-d8ad55712e15', false, 10, '2019-06-11T14:02:41.087Z', '2021-12-16T14:02:41.087Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (40, 6, 'b8587437-c3ac-427e-b22d-5c33315ad99f', false, 10, '2015-12-25T11:35:03.978Z', '2018-08-08T11:35:03.978Z', 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (41, 8, '7cb9dee0-4df6-45d9-80f0-f9c79174276a', true, 1, '2016-10-16T10:04:15.420Z', '2019-06-21T10:04:15.420Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (42, 13, '6f322ae9-0d2f-44dc-8d70-f38b519797fd', false, 5, '2020-11-20T23:09:11.481Z', '2022-01-30T23:09:11.481Z', 'IDLE');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (43, 0, 'f88ab601-647b-41a9-beee-7874c9699896', false, 3, '2022-05-13T01:01:43.034Z', null, 'RUNNING');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (44, 1, '881fc17f-f471-4d66-b57b-80374d069bed', false, 11, '2013-09-27T00:35:39.249Z', '2014-11-16T00:35:39.249Z', 'OFF');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (45, 12, 'a2edec5b-dda5-4ea7-815d-84c9646eefe0', false, 3, '2014-09-06T04:04:35.871Z', '2016-06-18T04:04:35.871Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (46, 2, '03568fc8-96e3-4dea-9aab-26e6391a5db0', false, 6, '2017-10-09T15:01:54.953Z', '2019-11-23T15:01:54.953Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (47, 12, '5c8ad8d1-c501-44c4-9162-1ee2a2dd530c', false, 11, '2019-06-03T04:22:37.230Z', '2022-04-11T04:22:37.230Z', 'STOP');
INSERT INTO machines (id, model_id, serial_number, need_maintenance, factory_id, created_at, last_maintenance_date, state) VALUES (48, 13, 'b65eb5c3-be65-487b-9ac8-4e4748de9a24', true, 4, '2014-05-08T09:44:31.216Z', '2016-10-23T09:44:31.216Z', 'STOP');