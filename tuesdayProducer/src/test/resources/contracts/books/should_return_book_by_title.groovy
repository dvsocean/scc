package contracts.books

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return book by title"

    request {
        url "/title/Identity"
        method "GET"
    }

    response {
        status 200
        headers {
            contentType "application/json"
        }
        body(
                title: "Identity",
                author: "TD Jakes",
                pubYear: 2017
        )
    }

}
