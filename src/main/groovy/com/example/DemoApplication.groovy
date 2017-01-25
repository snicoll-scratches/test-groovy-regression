package com.example

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class DemoApplication {

	static void main(String[] args) {
		def entity = createResponseEntity('application/json', 'test.zip')
		println entity.headers
	}

	private static ResponseEntity<String> createResponseEntity(String contentType, String fileName) {
		String contentDispositionValue = "attachment; filename=\"$fileName\""
		def result = new ResponseEntity<String>('test',
				['Content-Type'       : contentType,
				 'Content-Disposition': contentDispositionValue] as HttpHeaders, HttpStatus.OK)
		result
	}
}
