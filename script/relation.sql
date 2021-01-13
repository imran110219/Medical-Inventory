ALTER TABLE `generic`
  ADD PRIMARY KEY (`id`);
  
  
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `indication`
  ADD PRIMARY KEY (`id`);
  

ALTER TABLE `indication_generic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `indication_id` (`indication_id`),
  ADD KEY `generic_id` (`generic_id`);
  
  
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `generic_id` (`generic_id`),
  ADD KEY `company_id` (`company_id`);
  
  
ALTER TABLE `indication_generic`
  ADD CONSTRAINT `indication_generic_fk_indication` FOREIGN KEY (`indication_id`) REFERENCES `indication` (`id`),
  ADD CONSTRAINT `indication_generic_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`);
  
ALTER TABLE `brand`
  ADD CONSTRAINT `brand_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`),
  ADD CONSTRAINT `brand_fk_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);