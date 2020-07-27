insert into employee(id,employeeName,email,address, employeegbese,  employeetimeofarrival,scheduledtimeofarrival )
values(1,'Brume', 'brumelovee@gmail.com', 'flic en flac, mauritius', '567$', '2020-07-27 13:25:19', '2020-07-27 13:27:19'),
(2,'Brume2', 'brumelove7@gmail.com', 'flic en flac, mauritius', '897$', '2020-07-27 13:55:19', '2020-07-27 14:27:19')
ON CONFLICT DO NOTHING