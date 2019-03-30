import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/credit-scores/12345'
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body """
            {
                "score": "HIGH"
            }
        """
        headers {
            contentType applicationJson()
        }
    }
}
