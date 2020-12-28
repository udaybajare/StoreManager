package com.storemanager.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.storemanager.entity.ImageModel;
import com.storemanager.request.InventoryRequest;
import com.storemanager.request.InventoryUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.storemanager.dao.InventoryDao;
import com.storemanager.entity.Inventory;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryDao inventorydao;

    @PostMapping
    public ResponseEntity<?> saveInventory(@RequestBody InventoryRequest inventoryRequest) {
        try {


//            System.out.println("Original Image Byte Size - " + file.getBytes().length);
//
//           ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//                    compressBytes(file.getBytes()));
//            System.out.println("Image Store procress");
            Inventory inv = new Inventory(inventoryRequest.getCompanyName(),inventoryRequest.getProductCode(),inventoryRequest.getProductName(),inventoryRequest.getQuantity(),inventoryRequest.getUnitPrice(),inventoryRequest.getAvailableStatus(),inventoryRequest.getInventoryEntryDate());

          //  System.out.println("Image Store done");
//            System.out.println(inv);
//
//            System.out.println(inv.getCompanyName());
            return ResponseEntity.ok(inventorydao.save(inv));
        } catch (Exception ex) {
            System.out.println("Error "+ ex);
            ex.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
    
    @GetMapping("/getInventoryDetails")
    public ResponseEntity<?> getInventoryDetails() {
       
            List<Inventory> inventoryList = inventorydao.findAll();
//            for(Inventory inve :inventoryList){
//                ImageModel retrievedImage = inve.getImage();
//                ImageModel img = new ImageModel(retrievedImage.getName(), retrievedImage.getType(),
//                        decompressBytes(retrievedImage.getPicByte()));
//                System.out.println(img);
//            }


            return ResponseEntity.ok(inventoryList);
       
    }
    
    @GetMapping("/{companyName}")
   	public ResponseEntity<?> getProductList(@PathVariable (value="companyName")String companyName)
   	{
   	    //Add code for company name is no present
   		try
   		{
   			List<Inventory> inventory = inventorydao.findByCompanyName(companyName);
//            for(Inventory inve :inventory){
//                ImageModel retrievedImage = inve.getImage();
//                ImageModel img = new ImageModel(retrievedImage.getName(), retrievedImage.getType(),
//                        decompressBytes(retrievedImage.getPicByte()));
//                System.out.println(img);
//            }

   			System.out.println(inventory);
   			return ResponseEntity.ok(inventory);
   		}
   		catch (Exception ex)
   		{
   		    System.out.println("Error " +ex);
   			return ResponseEntity.noContent().build();
   		}
   	}


    @PatchMapping("/{productCode}")
    public ResponseEntity<?> updateInventory(@PathVariable(value = "productCode") String productCode, @RequestBody InventoryUpdateRequest inventoryUpdateRequest) {
        try {
            Inventory inventoryByName = inventorydao.findByProductCode(productCode);

//            ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//                    compressBytes(file.getBytes()));
//
//           // inventoryByName.setImage(img);
            if(inventoryUpdateRequest.getCompanyName() != null && !(inventoryUpdateRequest.getCompanyName().equals(""))){
            inventoryByName.setCompanyName(inventoryUpdateRequest.getCompanyName());}

            if(inventoryUpdateRequest.getProductName() != null && !(inventoryUpdateRequest.getProductName().equals(""))){
            inventoryByName.setProductName(inventoryUpdateRequest.getProductName());}

            if(inventoryUpdateRequest.getQuantity() != 0)
            inventoryByName.setQuantity(inventoryUpdateRequest.getQuantity());

            if(inventoryUpdateRequest.getUnitPrice() != 0)
            inventoryByName.setUnitPrice(inventoryUpdateRequest.getUnitPrice());

            if(inventoryUpdateRequest.getAvailableStatus() != null && !(inventoryUpdateRequest.getAvailableStatus().equals(""))){
            inventoryByName.setAvailableStatus(inventoryUpdateRequest.getAvailableStatus());}

            if(inventoryUpdateRequest.getInventoryEntryDate() != null && !(inventoryUpdateRequest.getInventoryEntryDate().equals(""))){
            inventoryByName.setInventoryEntryDate(inventoryUpdateRequest.getInventoryEntryDate());}

            return ResponseEntity.ok(inventorydao.save(inventoryByName));

        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }
}
