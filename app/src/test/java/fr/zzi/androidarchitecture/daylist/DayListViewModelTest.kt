package fr.zzi.androidarchitecture.daylist

import fr.zzi.androidarchitecture.feature.daylist.ui.DayListViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DayListViewModelTest {

    lateinit var viewModel: DayListViewModel

    @Before
    fun setup() {
        viewModel = DayListViewModel()
    }

    @Test
    fun `date is formated`() {
        val timestamp = 1579455961000
        val formatedDate = viewModel.formatDate(timestamp)
        val expectedDate = "19/12"

        Assert.assertEquals(formatedDate, expectedDate)
    }

    @Test
    fun `image URL is built`() {
        val imageName = "01d"
        val urlBuilt = viewModel.buildImageURL(imageName)
        val expectedUrl = "https://openweathermap.org/img/w/01d.png"

        Assert.assertEquals(urlBuilt, expectedUrl)
    }

}