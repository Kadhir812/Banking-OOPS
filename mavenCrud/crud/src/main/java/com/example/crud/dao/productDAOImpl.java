package com.example.crud.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.crud.dto.Product;

public class productDAOImpl implements productDAO {

	PreparedStatement stmt;
    Connection con;

    public productDAOImpl()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Immunoglobin@812");
			System.out.println("connection done");
			
			
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		
		
	}

    public void saveData(Product p) {
		
		try
		{
			
			  stmt=con.prepareStatement("insert into product values (?,?,?,?) ");
			  stmt.setInt(1,p.getProductId());
			  stmt.setString(2,p.getProductName());
 
			  stmt.setDouble(3,p.getPrice());
 
			  stmt.setString(4,p.getCity());
			  int c=stmt.executeUpdate();
			  if(c>0)
			  {
				  System.out.println("saved ");
			  }
			  else
			  {
				  System.out.println("error ");
			  }
 
 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
    }	

    public List<Product> showAll() {
		List<Product> products = new ArrayList<>();
		String query = "select * from product;";
		try{
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				products.add(new Product(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}

    public void removeById(int produt_id) {
        try {
            String sql = "delete from product where produt_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,produt_id);

            int rows = st.executeUpdate();

            if (rows > 0) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("No product found with given ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCityById(int produt_id, String city) {
        try {
            String sql = "update product set city = ? where produt_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, city);
            st.setInt(2, produt_id);

            int rows = st.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully");
            } else {
                System.out.println("No product found with given ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
