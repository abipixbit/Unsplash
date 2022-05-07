package com.example.splashexample.model.data

class UnsplashDataResponse : ArrayList<UnsplashDataResponse.UnsplashDataResponseItem>(){

    data class UnsplashDataResponseItem(
        val id: String,
        val created_at: String,
        val updated_at: String,
        val promoted_at: String,
        val width: Int,
        val height: Int,
        val color: String,
        val blur_hash: String,
        val description: String,
        val alt_description: Any,
        val urls: Urls,
        val links: Links,
        val categories: List<Any>,
        val likes: Int,
        val liked_by_user: Boolean,
        val current_user_collections: List<Any>,
        val sponsorship: Sponsorship,
        val topic_submissions: TopicSubmissions,
        val user: User
    ) {
        data class Urls(
            val raw: String,
            val full: String,
            val regular: String,
            val small: String,
            val thumb: String,
            val small_s3: String
        )
    
        data class Links(
            val self: String,
            val html: String,
            val download: String,
            val download_location: String
        )
    
        data class Sponsorship(
            val impression_urls: List<String>,
            val tagline: String,
            val tagline_url: String,
            val sponsor: Sponsor
        ) {
            data class Sponsor(
                val id: String,
                val updated_at: String,
                val username: String,
                val name: String,
                val first_name: String,
                val last_name: Any,
                val twitter_username: Any,
                val portfolio_url: String,
                val bio: String,
                val location: Any,
                val links: Links,
                val profile_image: ProfileImage,
                val instagram_username: Any,
                val total_collections: Int,
                val total_likes: Int,
                val total_photos: Int,
                val accepted_tos: Boolean,
                val for_hire: Boolean,
                val social: Social
            ) {
                data class Links(
                    val self: String,
                    val html: String,
                    val photos: String,
                    val likes: String,
                    val portfolio: String,
                    val following: String,
                    val followers: String
                )
    
                data class ProfileImage(
                    val small: String,
                    val medium: String,
                    val large: String
                )
    
                data class Social(
                    val instagram_username: Any,
                    val portfolio_url: String,
                    val twitter_username: Any,
                    val paypal_email: Any
                )
            }
        }
    
        class TopicSubmissions
    
        data class User(
            val id: String,
            val updated_at: String,
            val username: String,
            val name: String,
            val first_name: String,
            val last_name: String,
            val twitter_username: String,
            val portfolio_url: String,
            val bio: String,
            val location: String,
            val links: Links,
            val profile_image: ProfileImage,
            val instagram_username: String,
            val total_collections: Int,
            val total_likes: Int,
            val total_photos: Int,
            val accepted_tos: Boolean,
            val for_hire: Boolean,
            val social: Social
        ) {
            data class Links(
                val self: String,
                val html: String,
                val photos: String,
                val likes: String,
                val portfolio: String,
                val following: String,
                val followers: String
            )
    
            data class ProfileImage(
                val small: String,
                val medium: String,
                val large: String
            )
    
            data class Social(
                val instagram_username: String,
                val portfolio_url: String,
                val twitter_username: String,
                val paypal_email: Any
            )
        }
    }
}