package com.test.apps.myapplication.model

class ResponseJsonData {
    data class resultJsonData(
        val request_hash: String,
        var request_cachedval: Boolean,
        val request_cache_expiry: Int,
        var results: List<results>,
        var last_page: Int
    )

    data class results(
        var mal_id: Int,
        var url: String,
        var image_url: String,
        var title: String,
        var airing: Boolean,
        var synopsis: String,
        var type: String,
        var episodes: Int,
        var score: Float,
        var start_date: String,
        var end_date: String,
        var members: Int,
        var rated: String
    )
}