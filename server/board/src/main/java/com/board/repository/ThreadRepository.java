package com.board.repository;

import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.*;

import com.board.model.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Component
public interface ThreadRepository extends JpaRepository<Thread,Long>  {
	 
	


	
	
}
