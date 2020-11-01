package by.bsuir.ivan_bondarau.forum.repository

import by.bsuir.ivan_bondarau.forum.dao.MessageDao
import by.bsuir.ivan_bondarau.forum.dao.UserDao
import by.bsuir.ivan_bondarau.forum.model.Message
import by.bsuir.ivan_bondarau.forum.model.MessageWithAuthor
import by.bsuir.ivan_bondarau.forum.model.User
import java.util.*
import javax.inject.Inject

class MessageRepository @Inject constructor(private val messageDao: MessageDao, private val userDao: UserDao) {


    init {
        if (messageDao.findById(1) == null) {
            messageDao.insert(
                Message(
                    id = 1,
                    text = "ABA",
                    authorId = 1,
                    created = Calendar.getInstance().time
                )
            )
        }
        if (messageDao.findById(2) == null) {
            messageDao.insert(
                Message(
                    id = 2,
                    text = "CABA",
                    authorId = 2,
                    created = Calendar.getInstance().time
                )
            )
        }
    }


    fun findAll(): List<MessageWithAuthor>
        = messageDao.findAll().map {
            message -> MessageWithAuthor(message, userDao.findById(message.authorId))
        }

}