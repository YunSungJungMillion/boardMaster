package com.board.board.repository;

import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.*;

import com.board.board.model.Thread;

@Component
public interface ThreadRepository extends JpaRepository<Thread,Long>  {
	 

}
