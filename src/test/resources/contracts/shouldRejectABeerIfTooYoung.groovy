package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method ''
		url ''
		body(
				[:]
		)
		headers {

		}
	}
	response {
		status 200
		body( """

			""")
		headers {
			header(
					'Content-Type', value(consumer('application/json'),producer(regex('application/json.*')))
			)
		}
	}
}
