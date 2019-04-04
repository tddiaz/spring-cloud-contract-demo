package contracts.creditcardservice.http

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/credit-scores/12345'
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
