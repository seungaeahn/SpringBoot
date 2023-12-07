package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	List<CartItem> findCartItemByItemId(int id);
	CartItem findCartItemById(int id);
	
	//아이템 iD로 장바구니에서 상품 넣거나 찾을 수 있도록 Item을 통해 조회하거나
	//아이템을 집어넣을 수 있게 해주는 메서드 
	List<CartItem> findByItemId(int itemId);
	
	CartItem findCartIdAndItemId(Long cartId, int itemId);
	
	
}
