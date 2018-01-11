package cn.psycho.moviebeauty.http.retrofit.factory

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.Buffer
import retrofit2.Converter
import java.io.OutputStreamWriter
import java.nio.charset.Charset

/**
 * Created by Psycho on 2018/1/10.
 */
object StringRequestBodyConverter : Converter<String, RequestBody>{

    private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")
    private val UTF_8 = Charset.forName("UTF-8")

    override fun convert(value: String?): RequestBody {
        val buffer = Buffer()
        val writer = OutputStreamWriter(buffer.outputStream(), UTF_8)
        writer.write(value)
        writer.close()

        return RequestBody.create(MEDIA_TYPE, buffer.readByteString())
    }
}