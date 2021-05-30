-- Add Key

ALTER TABLE `generic`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `dosage_form`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `indication`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `sale_invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);  
  
ALTER TABLE `purchase_invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_id` (`supplier_id`);  

ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sale_invoice_id` (`sale_invoice_id`),
  ADD KEY `stock_id` (`stock_id`);

ALTER TABLE `indication_generic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `indication_id` (`indication_id`),
  ADD KEY `generic_id` (`generic_id`);
  
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dosage_form_id` (`dosage_form_id`),
  ADD KEY `generic_id` (`generic_id`),
  ADD KEY `manufacturer_id` (`manufacturer_id`);
  
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `purchase_invoice_id` (`purchase_invoice_id`);

ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `location_id` (`location_id`),
  ADD KEY `purchase_id` (`purchase_id`);

ALTER TABLE `returned`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sale_id` (`sale_id`),
  ADD KEY `purchase_id` (`purchase_id`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);
  
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `box`
  ADD PRIMARY KEY (`id`);

-- Enable Auto Increment

ALTER TABLE `brand`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `location`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `dosage_form`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `manufacturer`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `generic`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;
  
ALTER TABLE `indication`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `indication_generic`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `purchase`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `stock`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `returned`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `role`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `user_role`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `sale`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `supplier`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `user`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=5;
  
ALTER TABLE `box`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=4;

-- Add Foreign Key

ALTER TABLE `indication_generic`
  ADD CONSTRAINT `indication_generic_fk_indication` FOREIGN KEY (`indication_id`) REFERENCES `indication` (`id`),
  ADD CONSTRAINT `indication_generic_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`);
  
ALTER TABLE `brand`
  ADD CONSTRAINT `brand_fk_dosage_form` FOREIGN KEY (`dosage_form_id`) REFERENCES `dosage_form` (`id`),
  ADD CONSTRAINT `brand_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`),
  ADD CONSTRAINT `brand_fk_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`);

ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_role_fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
  
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_fk_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `purchase_fk_purchase_invoice` FOREIGN KEY (`purchase_invoice_id`) REFERENCES `purchase_invoice` (`id`);

ALTER TABLE `stock`
  ADD CONSTRAINT `stock_fk_location` FOREIGN KEY (`location_id`) REFERENCES `purchase` (`id`),
  ADD CONSTRAINT `stock_fk_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`);

ALTER TABLE `returned`
  ADD CONSTRAINT `returned_fk_sale` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`),
  ADD CONSTRAINT `returned_fk_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`);
  
ALTER TABLE `sale`
  ADD CONSTRAINT `sale_fk_sale_invoice` FOREIGN KEY (`sale_invoice_id`) REFERENCES `sale_invoice` (`id`),
  ADD CONSTRAINT `sale_fk_stock` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`);
  
ALTER TABLE `sale_invoice`
  ADD CONSTRAINT `sale_invoice_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `purchase_invoice`
  ADD CONSTRAINT `purchase_invoice_fk_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);
