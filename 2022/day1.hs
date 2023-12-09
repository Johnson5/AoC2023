module Main where
import System.IO
import Data.List

main :: IO ()
main = do
    let list = []
    handle <- openFile "inputs/day1.txt" ReadMode
    contents <- hGetContents handle
    let list = lines contents
    let intGroups = map toIntegers (groupStrings list)
    let result = sortBy (flip compare) $ map sum intGroups
    print $ sum (take 3 result)
        where
            toIntegers = map (\x -> read x :: Int)

groupStrings :: [String] -> [[String]]
groupStrings [] = []
groupStrings [x] = if null x then [] else [[x]]
groupStrings xs = fst (splitOnEmpty xs) : groupStrings ((\x -> if null x then [] else tail x) $ snd (splitOnEmpty xs))
    where
        splitOnEmpty = span (/= "")
