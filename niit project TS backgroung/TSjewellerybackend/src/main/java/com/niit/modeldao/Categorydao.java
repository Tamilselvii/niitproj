package com.niit.modeldao;

	import java.util.List;

import com.niit.modeldto.Category;

	public interface Categorydao {
		public void addcategory(Category category);
		public void updatecategory(Category category);
		public void deletecategory(int prodid);
		public void retrievecategory();

	public Category getCategoryByCategoryName(String username);
	public Category getCategoryByCategoryid(int categoryid);
	public List<Category>displayAll();

	}



