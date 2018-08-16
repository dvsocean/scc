package contracts.books

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return book by publishing year"

    request {
        url "/pubYear"
        method "POST"
    }

    response {
        status 400
        headers {
            contentType "application/json"
        }
        body([
                title: "Identity",
                author: "TD Jakes",
                pubYear: "2017"
        ])
    }
}
