package io.polygon.kotlin.sdk.rest.reference

import kotlinx.serialization.Serializable

/** See [PolygonReferenceRestClient.getMarketStatusBlocking] */
suspend fun PolygonReferenceRestClient.getMarketStatus(): MarketStatusDTO =
    polygonClient.fetchResult {
        path("v1", "marketstatus", "now")
    }

@Serializable
data class MarketStatusDTO(
    val market: String? = null,
    val serverTime: String? = null,
    val exchanges: ExchangesStatusDTO = ExchangesStatusDTO(),
    val currencies: CurrenciesStatusDTO = CurrenciesStatusDTO()
)

@Serializable
data class ExchangesStatusDTO(
    val nyse: String? = null,
    val nasdaq: String? = null,
    val otc: String? = null
)

@Serializable
data class CurrenciesStatusDTO(
    val fx: String? = null,
    val crypto: String? = null
)