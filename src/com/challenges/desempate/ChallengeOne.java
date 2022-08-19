package com.challenges.desempate

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.*

object ChallengeOne {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = FastReader()
        val pw = PrintWriter(System.out)
        
        val n = sc.nextInt()
        val m = sc.nextInt()

        pw.println("Ready $n $m")
        pw.close()
    }

    internal class FastReader {
        private var br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
        private var st: StringTokenizer? = null

        operator fun next(): String {
            while (st == null || !st!!.hasMoreElements()) {
                try {
                    st = StringTokenizer(br.readLine())
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return st!!.nextToken()
        }

        fun nextInt(): Int {
            return next().toInt()
        }

        fun nextLong(): Long {
            return next().toLong()
        }

        fun nextDouble(): Double {
            return next().toDouble()
        }

        fun nextLine(): String {
            var str = ""
            try {
                str = br.readLine()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return str
        }
    }
}