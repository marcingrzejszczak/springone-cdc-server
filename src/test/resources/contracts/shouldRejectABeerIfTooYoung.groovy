org.springframework.cloud.contract.spec.Contract.make {
			request {
				method 'POST'
				url '/check'
				body(
						name: 'josh',
						age: 17
					)
				headers {
						header 'Content-Type', 'application/json'
				}
			}
			response {
				status 200
				body( """{
							"status": "NOT_OK"
						}"""
				)
				headers {
						header('Content-Type', 
							value(
								consumer('application/json'),
								producer(regex('application/json.*'))
								)
							)
									
				}
			}
}
