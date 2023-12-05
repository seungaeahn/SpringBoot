package com.kh.OracleDB.mallBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.OracleDB.mallBoard.model.vo.Item;
import com.kh.OracleDB.mallBoard.repository.ItemRepository;

@Service
public class ItemService {
//상품을 추가하고 삭제하고 수정하는 기능
	private ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public void addItem(Item item, MultipartFile photoFile) throws IllegalStateException, IOException {
		
		//상품명과 저장될 파일명 경로생성
		//이미지 파일 정보에 대해서 추출
		String originPhotoName = photoFile.getOriginalFilename(); //업로드된 이미지 파일에 원본 파일명을 가져옴
		String photoName = ""; 
		String photoPath = System.getProperty("user.dir") + "src/main/resources/static/uploadImg/"; //업로드된 이미지 파일 경로 설정 
		//System.getProperty("user.dir")
		//System.getProperty() : 현재 코드가 작업하고 있는 폴더 위치 
		//"user.dir" : 현재 작업하고 있는 사용자 폴더를 나타냄
		//user.dir : C:/Users/user1/springBoot-workspace/JPA-imgUpload-Cart-Order 이 위치와 동일함 
		
		// 새로운 파일명을 생성해주기 위해 UUID
		UUID uuid = UUID.randomUUID();
		
		String saveFileName = "khShop_" + originPhotoName;
		//saveFileName으로 만약에 판매자가 사진1을 올리면 내 폴더 안에는 khshop_사진1 로 저장이 됨
		
		photoName = saveFileName;
		
		//import java.io.File
		//파일을 저장하기 위해 우리가 작성해놓은 파일을 작성하기 위한 공간이 비어있는 파일 객체를 가지고 옴
		//						파일을저장할경로    파일명
		File saveFile = new File(photoPath, photoName);
		
		//만약에 이름을 변경해서 저장하고 싶지 않다면 originPhotoName으로 저장해도 됨
		//판매자 컴퓨터에 있는 이미지 이름으로 그대로 업로드됨
		//File saveFile = new File(photoPath, originPhotoName);
		
		//업로드된 이미지 파일을 지정된 경로에 저장하기 위해 설정 
		//transferTo : 서버에 특정 경로에 저장할 수 있도록 해주는 메서드 
		photoFile.transferTo(saveFile);
		item.setPhotoName(photoName);
		item.setPhotoPath("/img/" + photoName);
		
		//DB에 저장할 수 있도록 save
		itemRepository.save(item);
	}
	
	//상품 읽기 find를 사용해서 개별 읽기
	public Item getItemById(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	//findById를 사용해서 Id에 해당하는 값을 가져오고
	// get을 이용해서 Item 객체를 반환 
	
	
	//모든 상품 가지고 오기 List
	public List<Item> allItemList() {
		return itemRepository.findAll();
	}
	
	public void itemDelete(Integer id) {
		itemRepository.deleteById(id);
	}
}
