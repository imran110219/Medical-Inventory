ALTER TABLE `generic`
  ADD PRIMARY KEY (`id`);
  
  
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `indication`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);  

ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `invoice_id` (`invoice_id`),
  ADD KEY `brand_id` (`brand_id`);

ALTER TABLE `indication_generic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `indication_id` (`indication_id`),
  ADD KEY `generic_id` (`generic_id`);
  
  
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `generic_id` (`generic_id`),
  ADD KEY `company_id` (`company_id`);
  
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `supplier_id` (`supplier_id`);
  
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`);
  
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `indication_generic`
  ADD CONSTRAINT `indication_generic_fk_indication` FOREIGN KEY (`indication_id`) REFERENCES `indication` (`id`),
  ADD CONSTRAINT `indication_generic_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`);
  
ALTER TABLE `brand`
  ADD CONSTRAINT `brand_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`),
  ADD CONSTRAINT `brand_fk_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);
  
ALTER TABLE `user`
  ADD CONSTRAINT `user_fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
  
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_fk_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `purchase_fk_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);
  
ALTER TABLE `sale`
  ADD CONSTRAINT `sale_fk_invoice` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  ADD CONSTRAINT `sale_fk_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);
  
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);