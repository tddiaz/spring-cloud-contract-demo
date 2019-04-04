package contracts.creditcardservice.http

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/credit-scores/54321'
    }
    response {
        status 200
        body """
            {
                "score": "LOW"
            }
        """
        headers {
            contentType applicationJson()
        }
    }
}
