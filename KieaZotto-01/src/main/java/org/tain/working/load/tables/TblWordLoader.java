package org.tain.working.load.tables;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TblWord;
import org.tain.jpa.repository.TblWordRepository;
import org.tain.tools.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TblWordLoader {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	@Autowired
	private TblWordRepository tblWordRepository;
	long id = 1L;
	
	public void loading() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.tblWordRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String fileName = this.projEnvParam.getBasePath() + File.separator + this.projEnvParam.getWordFile();
			String jsonData = StringTools.stringFromFile(fileName);
			List<TblWord> lst = new ObjectMapper().readValue(jsonData, new TypeReference<List<TblWord>>() {});
			lst.forEach(itm -> {
				itm.setId(id);
				this.tblWordRepository.save(itm);
				this.id ++;
			});
		}
	}
}
